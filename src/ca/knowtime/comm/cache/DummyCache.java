package ca.knowtime.comm.cache;

import ca.knowtime.comm.cache.keys.CacheKey;

public class DummyCache
        implements KnowTimeCache
{
    @Override
    public boolean contains( final CacheKey key ) {
        return false;
    }


    @Override
    public void put( final CacheKey key, final Object data, String eTag ) {
    }


    @Override
    public <T> T get( final CacheKey key ) {
        throw new CacheElementNotFound( key );
    }


    @Override
    public String eTag( final CacheKey key ) {
        throw new CacheElementNotFound( key );
    }
}
