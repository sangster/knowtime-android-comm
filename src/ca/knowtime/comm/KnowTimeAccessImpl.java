package ca.knowtime.comm;

import ca.knowtime.comm.cache.CacheGet;
import ca.knowtime.comm.cache.DummyCache;
import ca.knowtime.comm.cache.KnowTimeCache;
import ca.knowtime.comm.cache.keys.CacheKey;
import ca.knowtime.comm.cache.keys.RouteNamesKey;
import ca.knowtime.comm.cache.keys.RoutesStopTimesKey;
import ca.knowtime.comm.cache.keys.StopsKey;
import ca.knowtime.comm.parsers.PollRateParser;
import ca.knowtime.comm.parsers.RouteNamesParser;
import ca.knowtime.comm.parsers.RouteStopTimesParser;
import ca.knowtime.comm.parsers.StopsParser;
import ca.knowtime.comm.types.Location;
import ca.knowtime.comm.types.RouteName;
import ca.knowtime.comm.types.RouteStopTimes;
import ca.knowtime.comm.types.Stop;
import ca.knowtime.comm.types.User;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class KnowTimeAccessImpl
        implements KnowTimeAccess
{
    private final URI mBaseUrl;
    private final KnowTimeCache mCache;


    public KnowTimeAccessImpl( final URI baseUrl ) {
        this( baseUrl, new DummyCache() );
    }


    public KnowTimeAccessImpl( final URI baseUrl, final KnowTimeCache cache ) {
        mBaseUrl = baseUrl;
        mCache = cache;
    }


    @Override
    public User createUser( final int routeId )
            throws IOException {
        final URI newUserUri = mBaseUrl.resolve( "users" ).resolve( "new" );
        final HttpPost post = new HttpPost( newUserUri.resolve( Integer.toString( routeId ) ) );
        final Response res = Response.create( new HttpClient().execute( post, new BasicHttpContext() ) );

        switch( res.getCode() ) {
            case 201:
                return new User( UUID.fromString( res.getData() ), routeId, this );
            default:
                throw new RuntimeException( "Unknown Status Code: " + res.getCode() );
        }
    }


    @Override
    public void postLocation( final UUID userId, final Location location )
            throws IOException {
        final HttpPost post = new HttpPost( mBaseUrl.resolve( "user" ).resolve( userId.toString() ) );
        post.setHeader( "Accept", "application/json" );
        post.setHeader( "Content-Type", "application/json" );

        try {
            post.setEntity( new StringEntity( location.toJson().toString(), HTTP.UTF_8 ) );
            final Response res = Response.create( new HttpClient().execute( post, new BasicHttpContext() ) );
        } catch( UnsupportedEncodingException e ) {
            throw new RuntimeException( e );
        }
    }


    @Override
    public List<Stop> stops()
            throws IOException, JSONException {
        return new CacheGet<List<Stop>>( this, mCache, new StopsParser.Factory(), mBaseUrl.resolve( "stops" ),
                                         new StopsKey() ).get();
    }


    @Override
    public float pollRate()
            throws IOException, JSONException {
        final HttpGet httpGet = new HttpGet( mBaseUrl.resolve( "pollrate" ) );
        final Response res = Response.create( new HttpClient().execute( httpGet, new BasicHttpContext() ) );

        return new PollRateParser( res.getData() ).get();
    }


    @Override
    public List<RouteStopTimes> routesStopTimes( final int stopNumber, final Date date )
            throws IOException, JSONException {
        final Calendar cal = Calendar.getInstance();
        cal.setTime( date );

        return routesStopTimes( stopNumber, cal.get( Calendar.YEAR ), cal.get( Calendar.MONTH ),
                                cal.get( Calendar.DAY_OF_MONTH ) );
    }


    @Override
    public List<RouteStopTimes> routesStopTimes( final int stopNumber, final int year, final int month, final int day )
            throws IOException, JSONException {
        final String date = String.format( "%04d-%02d-%02d", year, month, day );
        final URI uri = mBaseUrl.resolve( "stoptimes" ).resolve( Integer.toString( stopNumber ) ).resolve( date );
        final CacheKey key = new RoutesStopTimesKey( stopNumber, year, month, day );

        return new CacheGet<List<RouteStopTimes>>( this, mCache, new RouteStopTimesParser.Factory(), uri, key ).get();
    }


    @Override
    public List<RouteName> routeNames()
            throws IOException, JSONException {
        return new CacheGet<List<RouteName>>( this, mCache, new RouteNamesParser.Factory(),
                                              mBaseUrl.resolve( "routes" ).resolve( "names" ),
                                              new RouteNamesKey() ).get();
    }
}
