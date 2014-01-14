package ca.knowtime.comm.parsers;

import ca.knowtime.comm.cache.CacheableResponse;

public interface ParserFactory<T>
{
    JsonParser<T> create(CacheableResponse res);
}
