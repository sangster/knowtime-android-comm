package ca.knowtime.comm.types;


public class OldStopTimePair
        implements Comparable<OldStopTimePair>
{
    private final OldStopTime mArrival;
    private final OldStopTime mDeparture;


    public OldStopTimePair( final OldStopTime arrival, final OldStopTime departure ) {
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
        final StringBuilder sb = new StringBuilder( "OldStopTimePair{" );
        sb.append( "arrival=" ).append( mArrival );
        sb.append( ", departure=" ).append( mDeparture );
        sb.append( '}' );
        return sb.toString();
    }


    @Override
    public int compareTo( final OldStopTimePair other ) {
        return mArrival.compareTo( other.mArrival );
    }
}
