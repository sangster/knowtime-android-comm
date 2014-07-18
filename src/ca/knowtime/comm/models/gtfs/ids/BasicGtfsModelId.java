package ca.knowtime.comm.models.gtfs.ids;

import ca.knowtime.comm.models.gtfs.GtfsModel;
import com.google.common.base.Preconditions;

public class BasicGtfsModelId
        extends GtfsModel
{
    protected final String mId;


    public BasicGtfsModelId( final String id ) {
        mId = Preconditions.checkNotNull( id );
    }


    public String getId() {
        return mId;
    }


    @Override
    public boolean equals( final Object o ) {
        if( this == o ) {
            return true;
        }
        if( !(o instanceof BasicGtfsModelId) ) {
            return false;
        }

        final BasicGtfsModelId that = (BasicGtfsModelId) o;
        return mId.equals( that.mId );
    }


    @Override
    public int hashCode() {
        return mId.hashCode();
    }
}
