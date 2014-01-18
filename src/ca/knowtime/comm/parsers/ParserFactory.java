package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.cache.CacheableResponse;

public interface ParserFactory<T>
{
    JsonParser<T> create( KnowTimeAccess knowTime, CacheableResponse res );
}
