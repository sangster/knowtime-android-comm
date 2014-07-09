package ca.knowtime.comm;

import android.net.Uri;
import ca.knowtime.comm.exceptions.InvalidPathPartException;
import ca.knowtime.comm.parsers.DataSetSummariesParser;
import ca.knowtime.comm.parsers.ParserFactory;
import ca.knowtime.comm.parsers.StopsParser;
import ca.knowtime.comm.responses.InnerObjectResponse;
import ca.knowtime.comm.responses.VoidResponse;
import ca.knowtime.comm.types.DataSetSummary;
import ca.knowtime.comm.types.KnowtimeModel;
import ca.knowtime.comm.types.Stop;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class KnowTimeAccessImpl
        implements KnowTimeAccess
{
    public static final String DEFAULT_TAG = KnowTimeAccess.class.getSimpleName();
    private final RequestQueue mRequestQueue;
    private final Uri mBaseUrl;


    public KnowTimeAccessImpl( final RequestQueue requestQueue, final Uri baseUrl ) {
        mRequestQueue = requestQueue;
        mBaseUrl = baseUrl;
    }


    @Override
    public void dataSets( final Response<List<DataSetSummary>> res ) {
        enqueueRequest( objectGetRequest( new DataSetSummariesParser.Factory(), res, "gtfs" ) );
    }


    @Override
    public void stops( Response<List<Stop>> res ) {
        enqueueRequest( objectGetRequest( new StopsParser.Factory(), res, "stops" ) );
    }


    private <T> void enqueueRequest( Request<T> req ) {
        req.setTag( DEFAULT_TAG );
        mRequestQueue.add( req );
    }


    private void cancelRequests( Object tag ) {
        if( mRequestQueue != null ) {
            mRequestQueue.cancelAll( tag );
        }
    }


    private <T> JsonRequest<JSONObject> objectRequest( final int method, final KnowtimeModel body,
                                                       ParserFactory<T> parser, Response<T> res,
                                                       final String... parts ) {
        final InnerObjectResponse<T> ior = new InnerObjectResponse<>( this, parser, res );
        final JSONObject request = body == null ? null : body.toJson();

        return new JsonObjectRequest( method, compileUri( parts ), request, ior, ior );
    }


    private <T> JsonRequest<JSONObject> objectRequest( final int method, final KnowtimeModel body,
                                                       ParserFactory<T> factory, ErrorResponse res,
                                                       final String... parts ) {
        final InnerObjectResponse<T> ior = new InnerObjectResponse<>( this,
                                                                      factory,
                                                                      new VoidResponse<T>( res ) );

        return new JsonObjectRequest( method,
                                      compileUri( parts ),
                                      body == null ? null : body.toJson(),
                                      ior,
                                      ior );
    }


    private <T> JsonRequest<JSONObject> objectGetRequest( ParserFactory<T> parser, Response<T> res,
                                                          final String... parts ) {
        return objectRequest( Request.Method.GET, null, parser, res, parts );
    }


    private String compileUri( final String[] parts ) {
        Uri.Builder builder = mBaseUrl.buildUpon();
        for( final String part : parts ) {
            try {
                builder = builder.appendPath( URLEncoder.encode( part, "UTF-8" ) );
            } catch( UnsupportedEncodingException e ) {
                throw new InvalidPathPartException( part );
            }
        }
        return builder.build().toString();
    }
}
