package ca.knowtime.comm.models;

import ca.knowtime.comm.KnowTimeAccess;

public class BasicKnowTimeModelId
        extends KnowTimeModel
{
    protected final String mId;


    public BasicKnowTimeModelId( final KnowTimeAccess access, final String id ) {
        super( access );
        mId = id;
    }


    public String getId() {
        return mId;
    }
}
