package ca.knowtime.comm.responses;

import android.util.Log;
import ca.knowtime.comm.RestAccess;
import ca.knowtime.comm.parsers.ParserFactory;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.common.base.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;


public class InnerObjectResponse<Type, Access extends RestAccess>
        implements Response.Listener<JSONObject>, Response.ErrorListener
{
    private static final String TAG = "InnerObjectResponse";
    private final ParserFactory<Type, Access> mFactory;
    private final ca.knowtime.comm.Response<Type> mResponse;


    public InnerObjectResponse( final ParserFactory<Type, Access> factory,
                                final ca.knowtime.comm.Response<Type> response ) {
        mFactory = Preconditions.checkNotNull( factory );
        mResponse = Preconditions.checkNotNull( response );
    }


    @Override
    public void onErrorResponse( final VolleyError error ) {
        Log.i( TAG, "onErrorResponse", error );
        mResponse.onErrorResponse( error );
    }


    @Override
    public void onResponse( final JSONObject response ) {
        Log.i( TAG, "onResponse:" + response );
        if( mFactory == null ) {
            return;
        }

        final String status = getStatus( response );

        if( status.equals( "success" ) ) {
            mResponse.onResponse( mFactory.parser( getData( response ) )
                                          .get() );
        }
    }


    private JSONObject getData( final JSONObject response ) {
        try {
            return response.getJSONObject( "data" );
        } catch( JSONException e ) {
            return new JSONObject();
        }
    }


    private String getStatus( final JSONObject response ) {
        try {
            return response.getString( "status" );
        } catch( JSONException e ) {
            return "badJsend";
        }
    }
}
