package ca.knowtime.comm.types;


public class StopTimePair
        implements Comparable<StopTimePair>
{
    private final StopTime mArrival;
    private final StopTime mDeparture;


    public StopTimePair( final StopTime arrival, final StopTime departure ) {
        mArrival = arrival;
        mDeparture = departure;
    }


    public StopTime getArrival() {
        return mArrival;
    }


    public StopTime getDeparture() {
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
