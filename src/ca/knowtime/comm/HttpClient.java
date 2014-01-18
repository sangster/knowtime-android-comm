package ca.knowtime.comm;


import android.net.http.AndroidHttpClient;
import ca.knowtime.comm.exceptions.HttpIoException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/** The client for making requests to the KNOWtime server */
public class HttpClient
{
    private static final String AGENT = "knowtime-android-comm-0.1";
    private static final AndroidHttpClient CLIENT = AndroidHttpClient.newInstance( AGENT );


    /**
     * Executes a request using the given context. The route to the target will be determined by the HTTP client.
     *
     * @param request
     *         the request to execute
     * @param context
     *         the context to use for the execution, or null to use the default context
     * @return the response to the request. This is always a final response, never an intermediate response with an 1xx
     *         status code. Whether redirects or authentication challenges will be returned or handled automatically
     *         depends on the implementation and configuration of this client
     */
    public HttpResponse execute( final HttpUriRequest request, final HttpContext context ) {
        try {
            return CLIENT.execute( request, context );
        } catch( final IOException e ) {
            throw new HttpIoException( e );
        }
    }


    /**
     * Executes a request using the default context.
     *
     * @param request
     *         the request to execute
     * @return the response to the request. This is always a final response, never an intermediate response with an 1xx
     *         status code. Whether redirects or authentication challenges will be returned or handled automatically
     *         depends on the implementation and configuration of this client
     */
    public HttpResponse execute( final HttpUriRequest request ) {
        try {
            return CLIENT.execute( request );
        } catch( IOException e ) {
            throw new HttpIoException( e );
        }
    }
}
