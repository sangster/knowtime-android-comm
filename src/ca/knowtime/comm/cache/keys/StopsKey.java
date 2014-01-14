package ca.knowtime.comm.cache.keys;

import ca.knowtime.comm.cache.CacheCategory;

public class StopsKey
        implements CacheKey
{
    @Override
    public CacheCategory getCategory() {
        return CacheCategory.stops;
    }


    @Override
    public boolean equals( final Object o ) {
        return o instanceof StopsKey;
    }


    @Override
    public int hashCode() {
        return 0;
    }
}
