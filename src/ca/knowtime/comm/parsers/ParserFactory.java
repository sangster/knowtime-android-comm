package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import org.json.JSONObject;

public interface ParserFactory<T>
{
    JsonParser<T> parser( KnowTimeAccess knowTime, JSONObject res );
}
