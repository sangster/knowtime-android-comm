package ca.knowtime.comm;

import android.content.Context;
import android.net.Uri;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class KnowTime
{
    public static KnowTimeAccess connect( final Context context, final Uri baseUrl ) {
        final RequestQueue requestQueue = Volley.newRequestQueue( context );

        return new KnowTimeAccessImpl( requestQueue,
                                       baseUrl,
                                       new GtfsAccessImpl( requestQueue, gtfsUrl( baseUrl ) ) );
    }


    private static Uri gtfsUrl( final Uri baseUrl ) {
        return baseUrl.buildUpon().appendPath( "gtfs" ).build();
    }
}
