package ca.knowtime.comm.models.gtfs.ids;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.models.gtfs.GtfsModel;

public class BasicGtfsModelId
        extends GtfsModel
{
    protected final String mId;


    public BasicGtfsModelId( final GtfsAccess access, final String id ) {
        super( access );
        mId = id;
    }


    public String getId() {
        return mId;
    }
}
