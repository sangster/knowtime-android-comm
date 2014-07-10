package ca.knowtime.comm;

import ca.knowtime.comm.types.Agency;
import ca.knowtime.comm.types.DataSetSummary;
import ca.knowtime.comm.types.Route;
import ca.knowtime.comm.types.Stop;
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
}

