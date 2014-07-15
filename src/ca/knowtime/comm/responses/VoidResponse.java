package ca.knowtime.comm.responses;

import ca.knowtime.comm.ErrorResponse;
import ca.knowtime.comm.Response;
import com.android.volley.VolleyError;


public class VoidResponse<T>
        extends Response<T>
{
    private final ErrorResponse mRes;


    public VoidResponse( final ErrorResponse res ) {

        mRes = res;
    }


    @Override
    public void onErrorResponse( final VolleyError error ) {
        mRes.onErrorResponse( error );
    }


    @Override
    public void onResponse( final T response ) {
    }
}
