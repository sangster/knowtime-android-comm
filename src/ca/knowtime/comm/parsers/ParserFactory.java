package ca.knowtime.comm.parsers;

import org.json.JSONObject;

public interface ParserFactory<T>
{
    public abstract JsonParser<T> parser( JSONObject res );
}
