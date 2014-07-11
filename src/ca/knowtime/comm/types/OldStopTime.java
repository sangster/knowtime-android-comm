package ca.knowtime.comm.types;

import java.util.Calendar;
import java.util.Date;

public class OldStopTime
        implements Comparable<OldStopTime>
{
    private final int mHours;
    private final int mMinutes;


    public static OldStopTime parse( final String str ) {
        return new OldStopTime( toInt( str.substring( 0, 2 ) ), toInt( str.substring( 3, 5 ) ) );
    }


    private static int toInt( final String str ) {
        return Integer.parseInt( str.substring( str.charAt( 0 ) == '0' ? 1 : 0 ) );
    }


    public OldStopTime( final int hours, final int minutes ) {
        mHours = hours;
        mMinutes = minutes;
    }


    public int getHours() {
        return mHours;
    }


    public int getMinutes() {
        return mMinutes;
    }


    public int getMinutesPastMidnight() {
        return mHours * 60 + mMinutes;
    }


    public Date forToday() {
        final Calendar cal = Calendar.getInstance();
        return forDate( cal.get( Calendar.YEAR ),
                        cal.get( Calendar.MONTH ),
                        cal.get( Calendar.DAY_OF_MONTH ) );
    }


    public Date forDate( final int year, final int month, final int day ) {
        final Calendar cal = Calendar.getInstance();
        cal.set( year, month, day, 0, 0, 0 );
        cal.add( Calendar.HOUR_OF_DAY, mHours );
        cal.add( Calendar.MINUTE, mMinutes );
        return cal.getTime();
    }


    @Override
    public boolean equals( final Object o ) {
        if( this == o ) {
            return true;
        }
        if( !(o instanceof OldStopTime) ) {
            return false;
        }

        final OldStopTime oldStopTime = (OldStopTime) o;

        if( mHours != oldStopTime.mHours ) {
            return false;
        }
        return mMinutes == oldStopTime.mMinutes;
    }


    @Override
    public int hashCode() {
        int result = mHours;
        result = 31 * result + mMinutes;
        return result;
    }


    @Override
    public String toString() {
        return String.format( "%02d:%02d", mHours, mMinutes );
    }


    @Override
    public int compareTo( final OldStopTime other ) {
        return getMinutesPastMidnight() - other.getMinutesPastMidnight();
    }
}
