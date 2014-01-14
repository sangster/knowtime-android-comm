package ca.knowtime.comm;


import android.net.http.AndroidHttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

public class HttpClient
{
    private static final String AGENT = "knowtime-android-comm-0.1";
    private static final AndroidHttpClient CLIENT = AndroidHttpClient.newInstance( AGENT );


    public HttpResponse execute( final HttpUriRequest request, final HttpContext context )
            throws IOException {
        return CLIENT.execute( request, context );
    }


    public HttpResponse execute( final HttpUriRequest request )
            throws IOException {
        return CLIENT.execute( request );
    }
}
