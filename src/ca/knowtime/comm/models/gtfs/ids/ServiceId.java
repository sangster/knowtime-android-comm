package ca.knowtime.comm.models.gtfs.ids;


public class ServiceId
        extends BasicGtfsModelId
{
    public ServiceId( final String id ) {
        super( id );
    }


    public String getServiceId() {
        return mId;
    }
}
