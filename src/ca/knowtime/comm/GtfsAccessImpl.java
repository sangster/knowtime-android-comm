package ca.knowtime.comm;

import android.net.Uri;
import ca.knowtime.comm.models.gtfs.Agency;
import ca.knowtime.comm.models.gtfs.Calendar;
import ca.knowtime.comm.models.gtfs.CalendarDate;
import ca.knowtime.comm.models.gtfs.DataSetSummary;
import ca.knowtime.comm.models.gtfs.FareAttribute;
import ca.knowtime.comm.models.gtfs.FareRule;
import ca.knowtime.comm.models.gtfs.FeedInfo;
import ca.knowtime.comm.models.gtfs.Frequency;
import ca.knowtime.comm.models.gtfs.Route;
import ca.knowtime.comm.models.gtfs.Shape;
import ca.knowtime.comm.models.gtfs.Stop;
import ca.knowtime.comm.models.gtfs.StopTime;
import ca.knowtime.comm.models.gtfs.Transfer;
import ca.knowtime.comm.models.gtfs.Trip;
import ca.knowtime.comm.parsers.gtfs.AgencyParser;
import ca.knowtime.comm.parsers.gtfs.CalendarDateParser;
import ca.knowtime.comm.parsers.gtfs.CalendarParser;
import ca.knowtime.comm.parsers.gtfs.DataSetSummaryParser;
import ca.knowtime.comm.parsers.gtfs.FareAttributeParser;
import ca.knowtime.comm.parsers.gtfs.FareRuleParser;
import ca.knowtime.comm.parsers.gtfs.FeedInfoParser;
import ca.knowtime.comm.parsers.gtfs.FrequencyParser;
import ca.knowtime.comm.parsers.gtfs.RouteParser;
import ca.knowtime.comm.parsers.gtfs.ShapeParser;
import ca.knowtime.comm.parsers.gtfs.StopParser;
import ca.knowtime.comm.parsers.gtfs.StopTimeParser;
import ca.knowtime.comm.parsers.gtfs.TransferParser;
import ca.knowtime.comm.parsers.gtfs.TripParser;
import com.android.volley.RequestQueue;

import java.util.List;

public class GtfsAccessImpl
        extends RestAccessImpl
        implements GtfsAccess
{
    public GtfsAccessImpl( final RequestQueue requestQueue, final Uri baseUrl ) {
        super( requestQueue, baseUrl );
    }


    @Override
    public void dataSets( final Object tag, final Response<List<DataSetSummary>> res ) {
        enqueueRequest( tag, new DataSetSummaryParser.ListFactory( this ), res );
    }


    @Override
    public void dataSet( final Object tag,
                         final String dataSetId,
                         final Response<DataSetSummary> res ) {
        enqueueRequest( tag, new DataSetSummaryParser.Factory( this ), res, dataSetId );
    }


    @Override
    public void agencies( final Object tag,
                          final String dataSetId,
                          final Response<List<Agency>> res ) {
        enqueueRequest( tag, new AgencyParser.ListFactory( this ), res, dataSetId, "agencies" );
    }


    @Override
    public void stops( final Object tag, final String dataSetId, final Response<List<Stop>> res ) {
        enqueueRequest( tag, new StopParser.ListFactory( this ), res, dataSetId, "stops" );
    }


    @Override
    public void stop( final Object tag,
                      final String dataSetId,
                      final String stopId,
                      final Response<Stop> res ) {
        enqueueRequest( tag, new StopParser.Factory( this ), res, dataSetId, "stops", stopId );
    }


    @Override
    public void routes( final Object tag,
                        final String dataSetId,
                        final Response<List<Route>> res ) {
        enqueueRequest( tag, new RouteParser.ListFactory( this ), res, dataSetId, "routes" );
    }


    @Override
    public void route( final Object tag,
                       final String dataSetId,
                       final String routeId,
                       final Response<Route> res ) {
        enqueueRequest( tag, new RouteParser.Factory( this ), res, dataSetId, "routes", routeId );
    }


    @Override
    public void trips( final Object tag, final String dataSetId, final Response<List<Trip>> res ) {
        enqueueRequest( tag, new TripParser.ListFactory( this ), res, dataSetId, "trips" );
    }


    @Override
    public void trip( final Object tag,
                      final String dataSetId,
                      final String tripId,
                      final Response<Trip> res ) {
        enqueueRequest( tag, new TripParser.Factory( this ), res, dataSetId, "trips", tripId );
    }


    @Override
    public void stopTimes( final Object tag,
                           final String dataSetId,
                           final Response<List<StopTime>> res ) {
        enqueueRequest( tag, new StopTimeParser.ListFactory( this ), res, dataSetId, "stop_times" );
    }


    @Override
    public void calendars( final Object tag,
                           final String dataSetId,
                           final Response<List<Calendar>> res ) {
        enqueueRequest( tag, new CalendarParser.ListFactory( this ), res, dataSetId, "calendars" );
    }


    @Override
    public void calendar( final Object tag,
                          final String dataSetId,
                          final String calendarId,
                          final Response<Calendar> res ) {
        enqueueRequest( tag,
                        new CalendarParser.Factory( this ),
                        res,
                        dataSetId,
                        "calendars",
                        calendarId );
    }


    @Override
    public void calendarDates( final Object tag,
                               final String dataSetId,
                               final Response<List<CalendarDate>> res ) {
        enqueueRequest( tag,
                        new CalendarDateParser.ListFactory( this ),
                        res,
                        dataSetId,
                        "calendar_dates" );
    }


    @Override
    public void calendarDate( final Object tag,
                              final String dataSetId,
                              final String calendarId,
                              final Response<CalendarDate> res ) {
        enqueueRequest( tag,
                        new CalendarDateParser.Factory( this ),
                        res,
                        dataSetId,
                        "calendar_dates",
                        calendarId );
    }


    @Override
    public void fareAttributes( final Object tag,
                                final String dataSetId,
                                final Response<List<FareAttribute>> res ) {
        enqueueRequest( tag,
                        new FareAttributeParser.ListFactory( this ),
                        res,
                        dataSetId,
                        "fare_attributes" );
    }


    @Override
    public void fareAttribute( final Object tag,
                               final String dataSetId,
                               final String fareId,
                               final Response<FareAttribute> res ) {
        enqueueRequest( tag,
                        new FareAttributeParser.Factory( this ),
                        res,
                        dataSetId,
                        "fare_attributes",
                        fareId );
    }


    @Override
    public void fareRules( final Object tag,
                           final String dataSetId,
                           final Response<List<FareRule>> res ) {
        enqueueRequest( tag, new FareRuleParser.ListFactory( this ), res, dataSetId, "fare_rules" );
    }


    @Override
    public void fareRule( final Object tag,
                          final String dataSetId,
                          final String fareId,
                          final Response<FareRule> res ) {
        enqueueRequest( tag,
                        new FareRuleParser.Factory( this ),
                        res,
                        dataSetId,
                        "fare_rules",
                        fareId );
    }


    @Override
    public void shapes( final Object tag,
                        final String dataSetId,
                        final Response<List<Shape>> res ) {
        enqueueRequest( tag, new ShapeParser.ListFactory( this ), res, dataSetId, "shapes" );
    }


    @Override
    public void shape( final Object tag,
                       final String dataSetId,
                       final String shapeId,
                       final Response<Shape> res ) {
        enqueueRequest( tag, new ShapeParser.Factory( this ), res, dataSetId, "shapes", shapeId );
    }


    @Override
    public void frequencies( final Object tag,
                             final String dataSetId,
                             final Response<List<Frequency>> res ) {
        enqueueRequest( tag,
                        new FrequencyParser.ListFactory( this ),
                        res,
                        dataSetId,
                        "frequencies" );
    }


    @Override
    public void frequency( final Object tag,
                           final String dataSetId,
                           final String tripId,
                           final Response<Frequency> res ) {
        enqueueRequest( tag,
                        new FrequencyParser.Factory( this ),
                        res,
                        dataSetId,
                        "frequencies",
                        tripId );
    }


    @Override
    public void transfers( final Object tag,
                           final String dataSetId,
                           final Response<List<Transfer>> res ) {
        enqueueRequest( tag, new TransferParser.ListFactory( this ), res, dataSetId, "transfers" );
    }


    @Override
    public void feedInfos( final Object tag,
                           final String dataSetId,
                           final Response<List<FeedInfo>> res ) {
        enqueueRequest( tag, new FeedInfoParser.ListFactory( this ), res, dataSetId, "feed_infos" );
    }
}
