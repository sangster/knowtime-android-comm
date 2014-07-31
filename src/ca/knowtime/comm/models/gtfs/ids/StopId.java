package ca.knowtime.comm.models.gtfs.ids;

public class StopId
        extends BasicGtfsModelId
{
    public StopId( final String id ) {
        super( id );
    }


    public String getStopId() {
        return mId;
    }
}
