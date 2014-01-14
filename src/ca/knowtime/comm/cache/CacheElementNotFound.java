package ca.knowtime.comm.cache;

import ca.knowtime.comm.cache.keys.CacheKey;

public class CacheElementNotFound
        extends RuntimeException
{
    public CacheElementNotFound( final CacheKey key ) {
        super( String.format( "Could not find cached element for key '%s'", key ) );
    }
}
