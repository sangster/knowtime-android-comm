package ca.knowtime.comm;

import android.content.Context;
import android.net.Uri;
import ca.knowtime.comm.types.DataSetSummary;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class KnowTime
{
    public static KnowTimeAccess connect( final Context context, final Uri baseUrl ) {
        final RequestQueue requestQueue = Volley.newRequestQueue( context );
        return new KnowTimeAccessImpl( requestQueue, baseUrl );
    }


    public static void dataSets( final Context context, final Uri baseUrl,
                                 Response<List<DataSetSummary>> res ) {
        connect( context, baseUrl ).dataSets( res );
    }
}
