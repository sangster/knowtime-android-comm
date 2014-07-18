package ca.knowtime.comm;

import android.net.Uri;
import android.util.Log;
import ca.knowtime.comm.models.DataSetSummary;
import ca.knowtime.comm.models.gtfs.Route;
import ca.knowtime.comm.models.gtfs.Stop;
import ca.knowtime.comm.parsers.DataSetSummaryParser;
import ca.knowtime.comm.parsers.gtfs.RouteParser;
import ca.knowtime.comm.parsers.gtfs.StopParser;
import com.android.volley.RequestQueue;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import static com.android.volley.Request.Method.POST;

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
    public void dataSets( final Object tag,
                          final Response<List<DataSetSummary>> res ) {
        enqueueRequest( tag,
                        new DataSetSummaryParser.ListFactory(),
                        res,
                        "data_sets" );
    }


    @Override
    public void stopsInBounds( final Object tag,
                               final String dataSetId,
                               final float lat1,
                               final float lon1,
                               final float lat2,
                               final float lon2,
                               final Response<List<Stop>> res ) {
        final JSONObject body = new JSONObject();
        try {
            body.put( "lat1", lat1 );
            body.put( "lon1", lon1 );
            body.put( "lat2", lat2 );
            body.put( "lon2", lon2 );
        } catch( final JSONException e ) {
            Log.e( "JON", "Error creating JSON object", e );
        }

        enqueueRequest( tag,
                        objectRequest( POST,
                                       body,
                                       new StopParser.ListFactory(),
                                       res,
                                       dataSetId,
                                       "stops",
                                       "within_bounds" ) );
    }


    @Override
    public void routesForStop( final Object tag,
                               final String dataSetId,
                               final String date,
                               final String stopId,
                               final Response<List<Route>> res ) {
        enqueueRequest( tag,
                        new RouteParser.ListFactory(),
                        res,
                        dataSetId,
                        "routes",
                        date,
                        "stop",
                        stopId );
    }
}
