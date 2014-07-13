package ca.knowtime.comm;

import android.net.Uri;
import ca.knowtime.comm.models.DataSetSummary;
import ca.knowtime.comm.parsers.DataSetSummaryParser;
import com.android.volley.RequestQueue;

import java.util.List;

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


    @Override
    public void dataSets( final Object tag, final Response<List<DataSetSummary>> res ) {
        enqueueRequest( tag, new DataSetSummaryParser.ListFactory( this ), res, "data_sets" );
    }
}
