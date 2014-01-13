package ca.knowtime.comm.exceptions;

import ca.knowtime.comm.KnowTimeCacheKey;

public class CacheElementNotFound
        extends RuntimeException
{
    public CacheElementNotFound( final KnowTimeCacheKey key, final String tag ) {
        super( String.format( "Could not find cached element for key '%s' and tag '%s'", key, tag ) );
    }
}
