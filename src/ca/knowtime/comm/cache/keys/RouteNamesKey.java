package ca.knowtime.comm.cache.keys;

import ca.knowtime.comm.cache.CacheCategory;

public class RouteNamesKey
        implements CacheKey
{
    @Override
    public CacheCategory getCategory() {
        return CacheCategory.routeNames;
    }


    @Override
    public boolean equals( final Object o ) {
        return o instanceof RouteNamesKey;
    }


    @Override
    public int hashCode() {
        return 0;
    }
}
