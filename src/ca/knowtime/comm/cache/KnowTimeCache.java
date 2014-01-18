package ca.knowtime.comm.cache;

import ca.knowtime.comm.cache.keys.CacheKey;

public interface KnowTimeCache
{
    boolean contains( CacheKey key );

    void put( CacheKey key, Object data, String eTag );

    <T> T get( CacheKey key );

    /**
     * @return the eTag which was returned from the HTTP server for the given key
     * @throws CacheElementNotFound
     *         if the given key does not exist in the cache
     */
    String eTag( CacheKey key );
}
