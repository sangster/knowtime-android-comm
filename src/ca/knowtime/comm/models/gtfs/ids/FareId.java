package ca.knowtime.comm.models.gtfs.ids;

public class FareId
        extends BasicGtfsModelId
{
    public FareId( final String id ) {
        super( id );
    }


    public String getFareId() {
        return mId;
    }
}
