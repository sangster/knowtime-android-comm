package ca.knowtime.comm.cache;

import ca.knowtime.comm.Response;
import ca.knowtime.comm.exceptions.HttpIoException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class CacheableResponse
        extends Response
{
    private final String mETag;


    public static CacheableResponse create( final HttpResponse response )
            throws HttpIoException {
        final Header[] headers = response.getHeaders( "ETag" );

        String tag = null;
        if( headers != null && headers.length > 0 ) {
            tag = headers[0].getValue();
        }

        return new CacheableResponse( tag, response.getStatusLine().getStatusCode(),
                                      getAsciiContentFromEntity( response.getEntity() ) );
    }


    private CacheableResponse( final String tag, final int code, final String data ) {
        super( code, data );
        mETag = tag;
    }


    public String getETag() {
        return mETag;
    }
}
