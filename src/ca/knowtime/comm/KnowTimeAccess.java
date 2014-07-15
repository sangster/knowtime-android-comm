package ca.knowtime.comm;

import ca.knowtime.comm.models.DataSetSummary;

import java.util.List;

/** Provides access to the KNOWtime server. */
public interface KnowTimeAccess
        extends RestAccess
{
    GtfsAccess gtfs();

    void dataSets( Object tag, Response<List<DataSetSummary>> res );
}

