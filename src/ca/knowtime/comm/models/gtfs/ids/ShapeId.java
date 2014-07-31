package ca.knowtime.comm.models.gtfs.ids;

public class ShapeId
        extends BasicGtfsModelId
{
    public ShapeId( final String id ) {
        super( id );
    }


    public String getShapeId() {
        return mId;
    }
}
