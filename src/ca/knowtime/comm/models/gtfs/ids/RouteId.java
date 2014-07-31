package ca.knowtime.comm.models.gtfs.ids;

public class RouteId
        extends BasicGtfsModelId
{
    public RouteId( final String id ) {
        super( id );
    }


    public String getRouteId() {
        return mId;
    }
}
