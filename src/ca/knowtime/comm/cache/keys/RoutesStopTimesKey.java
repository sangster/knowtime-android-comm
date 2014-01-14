package ca.knowtime.comm.cache.keys;

import ca.knowtime.comm.cache.CacheCategory;

public class RoutesStopTimesKey
        implements CacheKey
{
    private final int mStopNumber;
    private final int mYear;
    private final int mMonth;
    private final int mDay;


    public RoutesStopTimesKey( final int stopNumber, final int year, final int month, final int day ) {
        mStopNumber = stopNumber;
        mYear = year;
        mMonth = month;
        mDay = day;
    }


    @Override
    public CacheCategory getCategory() {
        return CacheCategory.stopTimes;
    }


    @Override
    public boolean equals( final Object o ) {
        if( this == o ) {
            return true;
        }
        if( !(o instanceof RoutesStopTimesKey) ) {
            return false;
        }

        final RoutesStopTimesKey that = (RoutesStopTimesKey) o;

        if( mDay != that.mDay ) {
            return false;
        }
        if( mMonth != that.mMonth ) {
            return false;
        }
        if( mStopNumber != that.mStopNumber ) {
            return false;
        }
        if( mYear != that.mYear ) {
            return false;
        }

        return true;
    }


    @Override
    public int hashCode() {
        int result = mStopNumber;
        result = 31 * result + mYear;
        result = 31 * result + mMonth;
        result = 31 * result + mDay;
        return result;
    }
}
