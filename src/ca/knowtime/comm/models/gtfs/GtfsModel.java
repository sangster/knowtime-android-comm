package ca.knowtime.comm.models.gtfs;


import ca.knowtime.comm.GtfsAccess;
import com.google.common.base.Preconditions;

public class GtfsModel
{
    protected final GtfsAccess mAccess;


    public GtfsModel( final GtfsAccess access ) {
        mAccess = Preconditions.checkNotNull( access );
    }
}
