package ca.knowtime.comm.types.ids;

import ca.knowtime.comm.KnowTimeAccess;

public class BasicModelId
        extends KnowtimeModelId
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
