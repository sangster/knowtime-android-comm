package ca.knowtime.comm;

import android.net.Uri;
import ca.knowtime.comm.cache.CacheGet;
import ca.knowtime.comm.cache.KnowTimeCache;
import ca.knowtime.comm.cache.keys.CacheKey;
import ca.knowtime.comm.cache.keys.EstimateKey;
import ca.knowtime.comm.cache.keys.RouteNamesKey;
import ca.knowtime.comm.cache.keys.RoutePathsKey;
import ca.knowtime.comm.cache.keys.RoutesStopTimesKey;
import ca.knowtime.comm.cache.keys.StopsKey;
import ca.knowtime.comm.exceptions.HttpIoException;
import ca.knowtime.comm.exceptions.InvalidPathPartException;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.parsers.EstimatesParser;
import ca.knowtime.comm.parsers.ParserFactory;
import ca.knowtime.comm.parsers.PathsParser;
import ca.knowtime.comm.parsers.PollRateParser;
import ca.knowtime.comm.parsers.RouteNamesParser;
import ca.knowtime.comm.parsers.RouteStopTimesParser;
import ca.knowtime.comm.parsers.StopsParser;
import ca.knowtime.comm.types.Estimate;
import ca.knowtime.comm.types.Location;
import ca.knowtime.comm.types.Path;
import ca.knowtime.comm.types.RouteName;
import ca.knowtime.comm.types.RouteStopTimes;
import ca.knowtime.comm.types.Stop;
import ca.knowtime.comm.types.User;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

public class KnowTimeAccessImpl
        implements KnowTimeAccess
{
    private final Uri mBaseUrl;
    private final KnowTimeCache mCache;


    public KnowTimeAccessImpl( final Uri baseUrl, final KnowTimeCache cache ) {
        mBaseUrl = baseUrl;
        mCache = cache;
    }


    @Override
    public User createUser( final int routeId )
            throws HttpIoException {
        final HttpPost post = post( "users", "new", Integer.toString( routeId ) );
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
            throws HttpIoException {
        final HttpPost post = post( "user", userId.toString() );
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
            throws HttpIoException, ParseException {
        return cacheGet( new StopsParser.Factory(), new StopsKey(), "stops" ).get();
    }


    @Override
    public float pollRate()
            throws HttpIoException, ParseException {
        final HttpGet httpGet = get( "pollrate" );
        final Response res = Response.create( new HttpClient().execute( httpGet, new BasicHttpContext() ) );
        return new PollRateParser( res.getData() ).get();
    }


    @Override
    public List<RouteStopTimes> routesStopTimes( final int stopNumber, final int year, final int month, final int day )
            throws HttpIoException, ParseException {
        return cacheGet( new RouteStopTimesParser.Factory(), new RoutesStopTimesKey( stopNumber, year, month, day ),
                         "stoptimes", Integer.toString( stopNumber ), dateString( year, month, day ) ).get();
    }


    private String dateString( final int year, final int month, final int day ) {
        return String.format( "%04d-%02d-%02d", year, month, day );
    }


    @Override
    public List<RouteName> routeNames()
            throws HttpIoException, ParseException {
        return cacheGet( new RouteNamesParser.Factory(), new RouteNamesKey(), "routes", "names" ).get();
    }


    @Override
    public List<Path> routePaths( final UUID routeId, final int year, final int month, final int day )
            throws HttpIoException, ParseException {
        return cacheGet( new PathsParser.Factory(), new RoutePathsKey( routeId, year, month, day ), "paths",
                         dateString( year, month, day ), routeId.toString() ).get();
    }


    @Override
    public List<Estimate> estimatesForShortName( final String shortName )
            throws HttpIoException, ParseException {
        return cacheGet( new EstimatesParser.Factory(), new EstimateKey( shortName ), "estimates",
                         "short:" + shortName ).get();
    }


    private HttpGet get( final String... parts ) {
        return new HttpGet( compileUri( parts ).toString() );
    }


    private HttpPost post( final String... parts ) {
        return new HttpPost( compileUri( parts ).toString() );
    }


    private <T> CacheGet<T> cacheGet( final ParserFactory<T> factory, final CacheKey cacheKey, final String... parts ) {
        return new CacheGet<T>( this, mCache, factory, compileUri( parts ), cacheKey );
    }


    private Uri compileUri( final String[] parts ) {
        Uri.Builder builder = mBaseUrl.buildUpon();
        for( final String part : parts ) {
            try {
                builder = builder.appendPath( URLEncoder.encode( part, "UTF-8" ) );
            } catch( UnsupportedEncodingException e ) {
                throw new InvalidPathPartException( part );
            }
        }
        return builder.build();
    }
}
