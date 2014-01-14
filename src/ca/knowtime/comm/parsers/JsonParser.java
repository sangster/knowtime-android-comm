package ca.knowtime.comm.parsers;

import org.json.JSONException;

/**
 *
 * @param <T> The type of object being deserialized
 */
public interface JsonParser<T>
{
    /** @return the result of deserializing the given JSON string */
    T get()
            throws JSONException;
}
