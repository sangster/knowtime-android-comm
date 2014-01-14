package ca.knowtime.comm.cache;

import ca.knowtime.comm.HttpClient;
import ca.knowtime.comm.cache.keys.CacheKey;
import ca.knowtime.comm.parsers.ParserFactory;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.BasicHttpContext;
import org.json.JSONException;

import java.io.IOException;
import java.net.URI;

public class CacheGet<T>
{
    private final KnowTimeCache mCache;
    private final ParserFactory<T> mParserFactory;
    private final URI mUri;
    private final CacheKey mKey;


    public CacheGet( final KnowTimeCache cache, final ParserFactory<T> parserFactory, final URI uri, final CacheKey key ) {
        mCache = cache;
        mParserFactory = parserFactory;
        mUri = uri;
        mKey = key;
    }


    public T get()
            throws IOException, JSONException {
        final HttpGet httpGet = new HttpGet( mUri );

        if( mCache.contains( mKey ) ) {
            httpGet.addHeader( "If-None-Match", mCache.eTag( mKey ) );
        }

        final CacheableResponse res = doGetMethod( httpGet );

        final T data;
        switch( res.getCode() ) {
            case 200:
                data = mParserFactory.create( res ).get();
                mCache.put( mKey, data, res.getETag() );
                break;
            case 304:
                data = mCache.get( mKey );
                break;
            default:
                throw new RuntimeException( "Unknown HTTP return: " + res.getCode() );
        }
        return data;
    }


    private CacheableResponse doGetMethod( final HttpGet httpGet )
            throws IOException {
        return CacheableResponse.create( new HttpClient().execute( httpGet, new BasicHttpContext() ) );
    }
}
