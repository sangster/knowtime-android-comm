package ca.knowtime.comm.cache.keys;

import ca.knowtime.comm.cache.CacheCategory;

import java.util.UUID;

public class RoutePathsKey
        implements CacheKey
{
    private final UUID mRouteId;
    private final int mYear;
    private final int mMonth;
    private final int mDay;


    public RoutePathsKey( final UUID routeId, final int year, final int month, final int day ) {
        mRouteId = routeId;
        mYear = year;
        mMonth = month;
        mDay = day;
    }


    @Override
    public CacheCategory getCategory() {
        return CacheCategory.routePaths;
    }


    @Override
    public boolean equals( final Object o ) {
        if( this == o ) {
            return true;
        }
        if( !(o instanceof RoutePathsKey) ) {
            return false;
        }

        final RoutePathsKey that = (RoutePathsKey) o;

        if( mDay != that.mDay ) {
            return false;
        }
        if( mMonth != that.mMonth ) {
            return false;
        }
        if( mYear != that.mYear ) {
            return false;
        }
        if( mRouteId != null ? !mRouteId.equals( that.mRouteId ) : that.mRouteId != null ) {
            return false;
        }

        return true;
    }


    @Override
    public int hashCode() {
        int result = mRouteId != null ? mRouteId.hashCode() : 0;
        result = 31 * result + mYear;
        result = 31 * result + mMonth;
        result = 31 * result + mDay;
        return result;
    }
}
