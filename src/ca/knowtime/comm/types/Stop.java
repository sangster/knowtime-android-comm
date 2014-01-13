package ca.knowtime.comm.types;

public class Stop
{
    private final int mStopNumber;
    private final String mName;
    private final Location mLocation;


    public Stop( final int stopNumber, final String name, final Location location ) {
        mStopNumber = stopNumber;
        mName = name;
        mLocation = location;
    }


    public int getStopNumber() {
        return mStopNumber;
    }


    public String getName() {
        return mName;
    }


    public Location getLocation() {
        return mLocation;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "Stop{" );
        sb.append( "number=" ).append( mStopNumber );
        sb.append( ", '" ).append( mName ).append( '\'' );
        sb.append( ", " ).append( mLocation );
        sb.append( '}' );
        return sb.toString();
    }
}
