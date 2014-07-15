package ca.knowtime.comm.models.gtfs.ids;


import ca.knowtime.comm.GtfsAccess;

public class TripId
        extends BasicGtfsModelId
{
    public TripId( final GtfsAccess knowTime, final String id ) {
        super( knowTime, id );
    }
}
