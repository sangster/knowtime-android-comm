package ca.knowtime.comm;

import ca.knowtime.comm.types.Agency;
import ca.knowtime.comm.types.Calendar;
import ca.knowtime.comm.types.CalendarDate;
import ca.knowtime.comm.types.DataSetSummary;
import ca.knowtime.comm.types.FareAttribute;
import ca.knowtime.comm.types.FareRule;
import ca.knowtime.comm.types.Frequency;
import ca.knowtime.comm.types.Route;
import ca.knowtime.comm.types.Shape;
import ca.knowtime.comm.types.Stop;
import ca.knowtime.comm.types.StopTime;
import ca.knowtime.comm.types.Transfer;
import ca.knowtime.comm.types.Trip;

import java.util.List;

/** Provides access to the KNOWtime server. */
public interface KnowTimeAccess
{
    void dataSets( Response<List<DataSetSummary>> res );

    void dataSet( String dataSetId, Response<DataSetSummary> res );

    void agencies( String dataSetId, Response<List<Agency>> res );

    void stops( String dataSetId, Response<List<Stop>> res );

    void stop( String dataSetId, String stopId, Response<Stop> res );

    void routes( String dataSetId, Response<List<Route>> res );

    void route( String dataSetId, String routeId, Response<Route> res );

    void trips( String dataSetId, Response<List<Trip>> res );

    void trip( String dataSetId, String tripId, Response<Trip> res );

    void stopTimes( String dataSetId, Response<List<StopTime>> res );

    void calendars( String dataSetId, Response<List<Calendar>> res );

    void calendar( String dataSetId, String calendarId, Response<Calendar> res );

    void calendarDates( String dataSetId, Response<List<CalendarDate>> res );

    void calendarDate( String dataSetId, String calendarId, Response<CalendarDate> res );

    void fareAttributes( String dataSetId, Response<List<FareAttribute>> res );

    void fareAttribute( String dataSetId, String fareId, Response<FareAttribute> res );

    void fareRules( String dataSetId, Response<List<FareRule>> res );

    void fareRule( String dataSetId, String fareId, Response<FareRule> res );

    void shapes( String dataSetId, Response<List<Shape>> res );

    void shape( String dataSetId, String shapeId, Response<Shape> res );

    void frequencies( String dataSetId, Response<List<Frequency>> res );

    void frequency( String dataSetId, String tripId, Response<Frequency> res );

    void transfers( String dataSetId, Response<List<Transfer>> res );
}

