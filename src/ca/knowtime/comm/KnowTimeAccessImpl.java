package ca.knowtime.comm;

import ca.knowtime.comm.exceptions.CacheElementNotFound;
import ca.knowtime.comm.parsers.StopsParser;
import ca.knowtime.comm.types.Stop;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

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
    public List<Stop> stops()
            throws IOException, JSONException {
        return new StopsParser( get( mBaseUrl.resolve( "stops" ) ) ).getStops();
    }


    private String get( final URI uri )
            throws IOException {
        final HttpGet httpGet = new HttpGet( uri );

        final HttpResponse response = new DefaultHttpClient().execute( httpGet, new BasicHttpContext() );
        return getAsciiContentFromEntity( response.getEntity() );
    }


    private String getAsciiContentFromEntity( final HttpEntity entity )
            throws IllegalStateException, IOException {
        final InputStream in = entity.getContent();

        final StringBuffer out = new StringBuffer();
        int n = 1;
        while( n > 0 ) {
            byte[] b = new byte[4096];
            n = in.read( b );
            if( n > 0 ) {
                out.append( new String( b, 0, n ) );
            }
        }
        return out.toString();
    }


    private static class DummyCache
            implements KnowTimeCache
    {
        @Override
        public boolean contains( final KnowTimeCacheKey key, final String tag ) {
            return false;
        }


        @Override
        public void put( final KnowTimeCacheKey key, final String tag, final Object data ) {
        }


        @Override
        public Object get( final KnowTimeCacheKey key, final String tag ) {
            throw new CacheElementNotFound( key, tag );
        }
    }
}




