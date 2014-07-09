package ca.knowtime.comm;


import ca.knowtime.comm.exceptions.HttpIoException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.io.InputStream;

public class Response
{
    private final int mCode;
    private final String mData;


    public static Response create( final HttpResponse response )
    throws HttpIoException {
        return new Response( response.getStatusLine().getStatusCode(),
                             getAsciiContentFromEntity( response.getEntity() ) );
    }


    protected static String getAsciiContentFromEntity( final HttpEntity entity )
    throws HttpIoException {
        try {
            final InputStream in = entity.getContent();
            final StringBuilder out = new StringBuilder();

            int n = 1;
            while( n > 0 ) {
                byte[] b = new byte[4096];
                n = in.read( b );
                if( n > 0 ) {
                    out.append( new String( b, 0, n ) );
                }
            }
            return out.toString();
        } catch( IOException e ) {
            throw new HttpIoException( e );
        }
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
