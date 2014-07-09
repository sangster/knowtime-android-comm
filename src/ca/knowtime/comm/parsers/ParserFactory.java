package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import org.json.JSONObject;

public interface ParserFactory<T>
{
    JsonParser<T> create( KnowTimeAccess knowTime, JSONObject res );
}
