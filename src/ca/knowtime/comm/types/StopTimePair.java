package ca.knowtime.comm.types;


public class StopTimePair
        implements Comparable<StopTimePair>
{
    private final OldStopTime mArrival;
    private final OldStopTime mDeparture;


    public StopTimePair( final OldStopTime arrival, final OldStopTime departure ) {
        mArrival = arrival;
        mDeparture = departure;
    }


    public OldStopTime getArrival() {
        return mArrival;
    }


    public OldStopTime getDeparture() {
        return mDeparture;
    }


    public int minutesAtStop() {
        return mDeparture.getMinutesPastMidnight() - mArrival.getMinutesPastMidnight();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "StopTimePair{" );
        sb.append( "arrival=" ).append( mArrival );
        sb.append( ", departure=" ).append( mDeparture );
        sb.append( '}' );
        return sb.toString();
    }


    @Override
    public int compareTo( final StopTimePair other ) {
        return mArrival.compareTo( other.mArrival );
    }
}
