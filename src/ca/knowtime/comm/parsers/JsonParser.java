package ca.knowtime.comm.parsers;

import ca.knowtime.comm.exceptions.ParseException;

/**
 *
 * @param <T> The type of object being deserialized
 */
public interface JsonParser<T>
{
    /** @return the requestComplete of deserializing the given JSON string */
    T get()
            throws ParseException;
}
