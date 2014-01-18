package ca.knowtime.comm.types;

public class Estimate
{
    private final Location mLocation;
    private final int mNextStopNumber;
    private final StopTime mEstimatedArrival;


    public Estimate( final Location location, final int nextStopNumber, final StopTime estimatedArrival ) {
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


    public StopTime getEstimatedArrival() {
        return mEstimatedArrival;
    }
}
