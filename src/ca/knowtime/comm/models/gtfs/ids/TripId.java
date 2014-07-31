package ca.knowtime.comm.models.gtfs.ids;


public class TripId
        extends BasicGtfsModelId
{
    public TripId( final String id ) {
        super( id );
    }


    public String getTripId() {
        return mId;
    }
}
