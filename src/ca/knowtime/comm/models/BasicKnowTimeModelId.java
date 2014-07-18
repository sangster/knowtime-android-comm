package ca.knowtime.comm.models;

public class BasicKnowTimeModelId
        extends KnowTimeModel
{
    protected final String mId;


    public BasicKnowTimeModelId( final String id ) {
        mId = id;
    }


    public String getId() {
        return mId;
    }
}
