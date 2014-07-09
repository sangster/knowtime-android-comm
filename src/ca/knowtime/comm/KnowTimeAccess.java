package ca.knowtime.comm;

import ca.knowtime.comm.types.DataSetSummary;
import ca.knowtime.comm.types.Stop;

import java.util.List;

/**
 * Provides access to the KNOWtime server. All of these methods are synchronous and will block until
 * the request is completed.
 */
public interface KnowTimeAccess
{
    void dataSets( Response<List<DataSetSummary>> res );

    void stops( Response<List<Stop>> res );
}

