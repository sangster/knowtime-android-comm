package ca.knowtime.comm;

import ca.knowtime.comm.models.DataSetSummary;
import ca.knowtime.comm.models.gtfs.Stop;

import java.util.List;

/** Provides access to the KNOWtime server. */
public interface KnowTimeAccess
        extends RestAccess
{
    GtfsAccess gtfs();

    void dataSets( Object tag, Response<List<DataSetSummary>> res );

    void stopsInBounds( Object tag,
                        String dataSetId,
                        float lat1,
                        float lon1,
                        float lat2,
                        float lon2,
                        Response<List<Stop>> res );
}

