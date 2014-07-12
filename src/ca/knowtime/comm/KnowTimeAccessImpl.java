package ca.knowtime.comm;

import android.net.Uri;
import com.android.volley.RequestQueue;

public class KnowTimeAccessImpl
        extends RestAccessImpl
        implements KnowTimeAccess
{
    private final GtfsAccess mGtfsAccess;


    public KnowTimeAccessImpl( final RequestQueue requestQueue,
                               final Uri baseUrl,
                               final GtfsAccess gtfsAccess ) {
        super( requestQueue, baseUrl );
        mGtfsAccess = gtfsAccess;
    }


    @Override
    public GtfsAccess gtfs() {
        return mGtfsAccess;
    }
}
