package ca.knowtime.comm;

public interface KnowTimeCache
{
    boolean contains( KnowTimeCacheKey key, String tag );

    void put( KnowTimeCacheKey key, String tag, Object data );

    Object get( KnowTimeCacheKey key, String tag );
}
