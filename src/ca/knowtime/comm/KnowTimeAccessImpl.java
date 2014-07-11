package ca.knowtime.comm;

import android.net.Uri;
import ca.knowtime.comm.exceptions.InvalidPathPartException;
import ca.knowtime.comm.parsers.AgencyParser;
import ca.knowtime.comm.parsers.CalendarDateParser;
import ca.knowtime.comm.parsers.CalendarParser;
import ca.knowtime.comm.parsers.DataSetSummariesParser;
import ca.knowtime.comm.parsers.FareAttributeParser;
import ca.knowtime.comm.parsers.FareRuleParser;
import ca.knowtime.comm.parsers.FrequencyParser;
import ca.knowtime.comm.parsers.ParserFactory;
import ca.knowtime.comm.parsers.RouteParser;
import ca.knowtime.comm.parsers.ShapeParser;
import ca.knowtime.comm.parsers.StopTimeParser;
import ca.knowtime.comm.parsers.StopsParser;
import ca.knowtime.comm.parsers.TransferParser;
import ca.knowtime.comm.parsers.TripParser;
import ca.knowtime.comm.responses.InnerObjectResponse;
import ca.knowtime.comm.responses.VoidResponse;
import ca.knowtime.comm.types.Agency;
import ca.knowtime.comm.types.Calendar;
import ca.knowtime.comm.types.CalendarDate;
import ca.knowtime.comm.types.DataSetSummary;
import ca.knowtime.comm.types.FareAttribute;
import ca.knowtime.comm.types.FareRule;
import ca.knowtime.comm.types.Frequency;
import ca.knowtime.comm.types.PostableKnowtimeModel;
import ca.knowtime.comm.types.Route;
import ca.knowtime.comm.types.Shape;
import ca.knowtime.comm.types.Stop;
import ca.knowtime.comm.types.StopTime;
import ca.knowtime.comm.types.Transfer;
import ca.knowtime.comm.types.Trip;
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
        enqueueRequest( new DataSetSummariesParser.ListFactory(), res, "gtfs" );
    }


    @Override
    public void dataSet( final String dataSetId, final Response<DataSetSummary> res ) {
        enqueueRequest( new DataSetSummariesParser.Factory(), res, "gtfs", dataSetId );
    }


    @Override
    public void agencies( final String dataSetId, final Response<List<Agency>> res ) {
        enqueueRequest( new AgencyParser.ListFactory(), res, "gtfs", dataSetId, "agencies" );
    }


    @Override
    public void stops( final String dataSetId, Response<List<Stop>> res ) {
        enqueueRequest( new StopsParser.ListFactory(), res, "gtfs", dataSetId, "stops" );
    }


    @Override
    public void stop( final String dataSetId, final String stopId, final Response<Stop> res ) {
        enqueueRequest( new StopsParser.Factory(), res, "gtfs", dataSetId, "stops", stopId );
    }


    @Override
    public void routes( final String dataSetId, final Response<List<Route>> res ) {
        enqueueRequest( new RouteParser.ListFactory(), res, "gtfs", dataSetId, "routes" );
    }


    @Override
    public void route( final String dataSetId, final String routeId, final Response<Route> res ) {
        enqueueRequest( new RouteParser.Factory(), res, "gtfs", dataSetId, "routes", routeId );
    }


    @Override
    public void trips( final String dataSetId, final Response<List<Trip>> res ) {
        enqueueRequest( new TripParser.ListFactory(), res, "gtfs", dataSetId, "trips" );
    }


    @Override
    public void trip( final String dataSetId, final String tripId, final Response<Trip> res ) {
        enqueueRequest( new TripParser.Factory(), res, "gtfs", dataSetId, "trips", tripId );
    }


    @Override
    public void stopTimes( final String dataSetId, final Response<List<StopTime>> res ) {
        enqueueRequest( new StopTimeParser.ListFactory(), res, "gtfs", dataSetId, "stop_times" );
    }


    @Override
    public void calendars( final String dataSetId, final Response<List<Calendar>> res ) {
        enqueueRequest( new CalendarParser.ListFactory(), res, "gtfs", dataSetId, "calendars" );
    }


    @Override
    public void calendar( final String dataSetId, final String calendarId,
                          final Response<Calendar> res ) {
        enqueueRequest( new CalendarParser.Factory(),
                        res,
                        "gtfs",
                        dataSetId,
                        "calendars",
                        calendarId );
    }


    @Override
    public void calendarDates( final String dataSetId, final Response<List<CalendarDate>> res ) {
        enqueueRequest( new CalendarDateParser.ListFactory(),
                        res,
                        "gtfs",
                        dataSetId,
                        "calendar_dates" );
    }


    @Override
    public void calendarDate( final String dataSetId, final String calendarId,
                              final Response<CalendarDate> res ) {
        enqueueRequest( new CalendarDateParser.Factory(),
                        res,
                        "gtfs",
                        dataSetId,
                        "calendar_dates",
                        calendarId );
    }


    @Override
    public void fareAttributes( final String dataSetId, final Response<List<FareAttribute>> res ) {
        enqueueRequest( new FareAttributeParser.ListFactory(),
                        res,
                        "gtfs",
                        dataSetId,
                        "fare_attributes" );
    }


    @Override
    public void fareAttribute( final String dataSetId, final String fareId,
                               final Response<FareAttribute> res ) {
        enqueueRequest( new FareAttributeParser.Factory(),
                        res,
                        "gtfs",
                        dataSetId,
                        "fare_attributes",
                        fareId );
    }


    @Override
    public void fareRules( final String dataSetId, final Response<List<FareRule>> res ) {
        enqueueRequest( new FareRuleParser.ListFactory(), res, "gtfs", dataSetId, "fare_rules" );
    }


    @Override
    public void fareRule( final String dataSetId, final String fareId,
                          final Response<FareRule> res ) {
        enqueueRequest( new FareRuleParser.Factory(),
                        res,
                        "gtfs",
                        dataSetId,
                        "fare_rules",
                        fareId );
    }


    @Override
    public void shapes( final String dataSetId, final Response<List<Shape>> res ) {
        enqueueRequest( new ShapeParser.ListFactory(), res, "gtfs", dataSetId, "shapes" );
    }


    @Override
    public void shape( final String dataSetId, final String shapeId, final Response<Shape> res ) {
        enqueueRequest( new ShapeParser.Factory(), res, "gtfs", dataSetId, "shapes", shapeId );
    }


    @Override
    public void frequencies( final String dataSetId, final Response<List<Frequency>> res ) {
        enqueueRequest( new FrequencyParser.ListFactory(), res, "gtfs", dataSetId, "frequencies" );
    }


    @Override
    public void frequency( final String dataSetId, final String tripId,
                           final Response<Frequency> res ) {
        enqueueRequest( new FrequencyParser.Factory(),
                        res,
                        "gtfs",
                        dataSetId,
                        "frequencies",
                        tripId );
    }


    @Override
    public void transfers( final String dataSetId, final Response<List<Transfer>> res ) {
        enqueueRequest( new TransferParser.ListFactory(), res, "gtfs", dataSetId, "transfers" );
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


    private <T> JsonRequest<JSONObject> objectRequest( final int method,
                                                       final PostableKnowtimeModel body,
                                                       ParserFactory<T> parser, Response<T> res,
                                                       final String... parts ) {
        final InnerObjectResponse<T> ior = new InnerObjectResponse<>( this, parser, res );
        final JSONObject request = body == null ? null : body.toJson();

        return new JsonObjectRequest( method, compileUri( parts ), request, ior, ior );
    }


    private <T> JsonRequest<JSONObject> objectRequest( final int method,
                                                       final PostableKnowtimeModel body,
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


    private <T> void enqueueRequest( ParserFactory<T> parser, Response<T> res,
                                     final String... parts ) {
        enqueueRequest( objectRequest( Request.Method.GET, null, parser, res, parts ) );
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
