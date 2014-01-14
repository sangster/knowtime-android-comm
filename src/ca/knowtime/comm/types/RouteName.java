package ca.knowtime.comm.types;

public class RouteName
{
    private final String mShortName;
    private final String mLongName;


    public RouteName( final String shortName, final String longName ) {
        mShortName = shortName;
        mLongName = longName;
    }


    public String getShortName() {
        return mShortName;
    }


    public String getLongName() {
        return mLongName;
    }
}
