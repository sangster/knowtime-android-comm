package ca.knowtime.comm.models.gtfs.ids;

import ca.knowtime.comm.GtfsAccess;

public class RouteId
        extends BasicGtfsModelId
{
    public RouteId( final GtfsAccess knowTime, final String id ) {
        super( knowTime, id );
    }
}
