package ca.knowtime.comm.responses;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.parsers.ParserFactory;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import org.json.JSONException;
import org.json.JSONObject;


public class InnerObjectResponse<T>
        implements Response.Listener<JSONObject>, Response.ErrorListener
{
    private final KnowTimeAccess mAccess;
    private final ParserFactory<T> mParser;
    private final ca.knowtime.comm.Response<T> mResponse;


    public InnerObjectResponse( final KnowTimeAccess access, final ParserFactory<T> parser,
                                final ca.knowtime.comm.Response<T> response ) {
        mAccess = access;
        mParser = parser;
        mResponse = response;
    }


    @Override
    public void onErrorResponse( final VolleyError error ) {
        mResponse.onErrorResponse( error );
    }


    @Override
    public void onResponse( final JSONObject response ) {
        if( mParser == null ) {
            return;
        }

        final String status = getStatus( response );

        if( status.equals( "success" ) ) {
            mResponse.onResponse( mParser.create( mAccess, getData( response ) ).get() );
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
