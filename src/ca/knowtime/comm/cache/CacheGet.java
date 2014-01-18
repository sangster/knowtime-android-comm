package ca.knowtime.comm.cache;

import android.net.Uri;
import ca.knowtime.comm.HttpClient;
import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.cache.keys.CacheKey;
import ca.knowtime.comm.exceptions.HttpIoException;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.exceptions.UnexpectedReturnCodeException;
import ca.knowtime.comm.parsers.ParserFactory;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.BasicHttpContext;

public class CacheGet<T>
{
    private final KnowTimeAccess mKnowTime;
    private final KnowTimeCache mCache;
    private final ParserFactory<T> mParserFactory;
    private final Uri mUri;
    private final CacheKey mKey;


    public CacheGet( final KnowTimeAccess knowTime, final KnowTimeCache cache, final ParserFactory<T> parserFactory,
                     final Uri uri, final CacheKey key ) {
        mKnowTime = knowTime;
        mCache = cache;
        mParserFactory = parserFactory;
        mUri = uri;
        mKey = key;
    }


    public T get()
            throws HttpIoException, ParseException {
        final HttpGet httpGet = new HttpGet( mUri.toString() );

        if( mCache.contains( mKey ) ) {
            httpGet.addHeader( "If-None-Match", mCache.eTag( mKey ) );
        }

        final CacheableResponse res = doGetMethod( httpGet );

        final T data;
        switch( res.getCode() ) {
            case 200:
                data = mParserFactory.create( mKnowTime, res ).get();
                mCache.put( mKey, data, res.getETag() );
                break;
            case 304:
                data = mCache.get( mKey );
                break;
            default:
                throw new UnexpectedReturnCodeException( res.getCode() );
        }
        return data;
    }


    private CacheableResponse doGetMethod( final HttpGet httpGet )
            throws HttpIoException {
        return CacheableResponse.create( new HttpClient().execute( httpGet, new BasicHttpContext() ) );
    }
}
