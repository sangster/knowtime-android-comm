package ca.knowtime.comm;

import ca.knowtime.comm.cache.KnowTimeCache;

import java.net.URI;

public class KnowTime
{
    public static KnowTimeAccess connect( final URI baseUrl, final KnowTimeCache cache ) {
        return new KnowTimeAccessImpl( baseUrl, cache );
    }
}
