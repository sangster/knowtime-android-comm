package ca.knowtime.comm;

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

import java.util.List;

public interface GtfsAccess
        extends RestAccess
{
    void dataSets( Object tag, Response<List<DataSetSummary>> res );

    void dataSet( Object tag, String dataSetId, Response<DataSetSummary> res );

    void agencies( Object tag, String dataSetId, Response<List<Agency>> res );

    void stops( Object tag, String dataSetId, Response<List<Stop>> res );

    void stop( Object tag, String dataSetId, String stopId, Response<Stop> res );

    void routes( Object tag, String dataSetId, Response<List<Route>> res );

    void route( Object tag, String dataSetId, String routeId, Response<Route> res );

    void trips( Object tag, String dataSetId, Response<List<Trip>> res );

    void trip( Object tag, String dataSetId, String tripId, Response<Trip> res );

    void stopTimes( Object tag, String dataSetId, Response<List<StopTime>> res );

    void calendars( Object tag, String dataSetId, Response<List<Calendar>> res );

    void calendar( Object tag, String dataSetId, String calendarId, Response<Calendar> res );

    void calendarDates( Object tag, String dataSetId, Response<List<CalendarDate>> res );

    void calendarDate( Object tag,
                       String dataSetId,
                       String calendarId,
                       Response<CalendarDate> res );

    void fareAttributes( Object tag, String dataSetId, Response<List<FareAttribute>> res );

    void fareAttribute( Object tag, String dataSetId, String fareId, Response<FareAttribute> res );

    void fareRules( Object tag, String dataSetId, Response<List<FareRule>> res );

    void fareRule( Object tag, String dataSetId, String fareId, Response<FareRule> res );

    void shapes( Object tag, String dataSetId, Response<List<Shape>> res );

    void shape( Object tag, String dataSetId, String shapeId, Response<Shape> res );

    void frequencies( Object tag, String dataSetId, Response<List<Frequency>> res );

    void frequency( Object tag, String dataSetId, String tripId, Response<Frequency> res );

    void transfers( Object tag, String dataSetId, Response<List<Transfer>> res );

    void feedInfos( Object tag, String dataSetId, Response<List<FeedInfo>> res );
}
