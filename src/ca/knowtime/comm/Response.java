package ca.knowtime.comm;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.io.InputStream;

public class Response
{
    private final int mCode;
    private final String mData;


    static Response create( final HttpResponse response )
            throws IOException {
        return new Response( response.getStatusLine().getStatusCode(),
                             getAsciiContentFromEntity( response.getEntity() ) );
    }


    protected static String getAsciiContentFromEntity( final HttpEntity entity )
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


    public Response( final int code, final String data ) {
        mCode = code;
        mData = data;
    }


    public int getCode() {
        return mCode;
    }


    public String getData() {
        return mData;
    }
}
