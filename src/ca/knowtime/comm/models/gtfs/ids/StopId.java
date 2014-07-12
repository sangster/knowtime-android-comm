package ca.knowtime.comm.models.gtfs.ids;

import ca.knowtime.comm.GtfsAccess;

public class StopId
        extends BasicGtfsModelId
{
    public StopId( final GtfsAccess knowTime, final String id ) {
        super( knowTime, id );
    }
}
