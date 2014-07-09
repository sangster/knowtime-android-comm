package ca.knowtime.comm;

import com.android.volley.VolleyError;

public abstract class Response<T>
        implements ErrorResponse
{
    @Override
    public void onErrorResponse( final VolleyError error ) {
        // no-op
    }


    public abstract void onResponse( final T response );
}
