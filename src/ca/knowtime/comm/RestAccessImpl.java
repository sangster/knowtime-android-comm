package ca.knowtime.comm;

import android.net.Uri;
import android.util.Log;
import ca.knowtime.comm.exceptions.InvalidPathPartException;
import ca.knowtime.comm.parsers.ParserFactory;
import ca.knowtime.comm.responses.InnerObjectResponse;
import ca.knowtime.comm.responses.VoidResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class RestAccessImpl
        implements RestAccess
{
    protected final RequestQueue mRequestQueue;
    protected final Uri mBaseUrl;


    public RestAccessImpl( final RequestQueue requestQueue,
                           final Uri baseUrl ) {
        mRequestQueue = requestQueue;
        mBaseUrl = baseUrl;
    }


    @Override
    public void cancel( final Object tag ) {
        if( mRequestQueue != null ) {
            mRequestQueue.cancelAll( tag );
        }
    }


    protected <T> void enqueueRequest( final Object tag, Request<T> req ) {
        req.setTag( tag );
        mRequestQueue.add( req );
    }


    protected <T, A extends RestAccess> JsonRequest<JSONObject> objectRequest(
            final int method,
            final JSONObject body,
            final ParserFactory<T, A> parser,
            final Response<T> res,
            final String... parts ) {
        InnerObjectResponse<T, A> ior = new InnerObjectResponse<>( parser,
                                                                   res );

        return new JsonObjectRequest( method,
                                      compileUri( parts ),
                                      body,
                                      ior,
                                      ior );
    }


    protected <T, A extends RestAccess> JsonRequest<JSONObject> objectRequest(
            final int method,
            final JSONObject body,
            final ParserFactory<T, A> factory,
            final ErrorResponse res,
            final String... parts ) {
        InnerObjectResponse<T, A> ior = new InnerObjectResponse<>( factory,
                                                                   new VoidResponse<T>(
                                                                           res ) );

        return new JsonObjectRequest( method,
                                      compileUri( parts ),
                                      body,
                                      ior,
                                      ior );
    }


    protected <T, A extends RestAccess> JsonRequest<JSONObject> objectGetRequest(
            final ParserFactory<T, A> parser,
            final Response<T> res,
            final String... parts ) {
        return objectRequest( Request.Method.GET, null, parser, res, parts );
    }


    protected <T, A extends RestAccess> void enqueueRequest( final Object tag,
                                                             final ParserFactory<T, A> parser,
                                                             final Response<T> res,
                                                             final String... parts ) {
        enqueueRequest( tag,
                        objectRequest( Request.Method.GET,
                                       null,
                                       parser,
                                       res,
                                       parts ) );
    }


    private String compileUri( final String[] parts ) {
        Uri.Builder builder = mBaseUrl.buildUpon();
        for( final String part : parts ) {
            try {
                builder = builder.appendPath( URLEncoder.encode( part,
                                                                 "UTF-8" ) );
            } catch( UnsupportedEncodingException e ) {
                throw new InvalidPathPartException( part );
            }
        }
        final String uri = builder.build().toString();
        Log.d( "compileUri", uri );
        return uri;
    }
}
