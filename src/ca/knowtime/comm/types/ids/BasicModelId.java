package ca.knowtime.comm.types.ids;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.KnowtimeModel;

public class BasicModelId
        extends KnowtimeModel
{
    protected final String mId;


    public BasicModelId( final KnowTimeAccess knowTime, final String id ) {
        super( knowTime );
        mId = id;
    }


    public String getId() {
        return mId;
    }
}
