package ca.knowtime.comm.types;

public class Estimate
{
    private final Location mLocation;
    private final int mNextStopNumber;
    private final OldStopTime mEstimatedArrival;


    public Estimate( final Location location, final int nextStopNumber, final OldStopTime estimatedArrival ) {
        mLocation = location;
        mNextStopNumber = nextStopNumber;
        mEstimatedArrival = estimatedArrival;
    }


    public Location getLocation() {
        return mLocation;
    }


    public int getNextStopNumber() {
        return mNextStopNumber;
    }


    public OldStopTime getEstimatedArrival() {
        return mEstimatedArrival;
    }
}
