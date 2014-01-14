package ca.knowtime.comm;

import ca.knowtime.comm.cache.CacheGet;
import ca.knowtime.comm.cache.CacheableResponse;
import ca.knowtime.comm.cache.DummyCache;
import ca.knowtime.comm.cache.KnowTimeCache;
import ca.knowtime.comm.cache.keys.StopsKey;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ParserFactory;
import ca.knowtime.comm.parsers.StopsParser;
import ca.knowtime.comm.types.Location;
import ca.knowtime.comm.types.Stop;
import ca.knowtime.comm.types.User;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
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
        final HttpPost post = new HttpPost( mBaseUrl.resolve( "users/new" ).resolve( Integer.toString( routeId ) ) );
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
        return new CacheGet<List<Stop>>( mCache, new StopsParserFactory(), mBaseUrl.resolve( "stops" ),
                                         new StopsKey() ).get();
    }


    private static class StopsParserFactory
            implements ParserFactory<List<Stop>>
    {
        @Override
        public JsonParser<List<Stop>> create( CacheableResponse res ) {
            return new StopsParser( res.getData() );
        }
    }
}




