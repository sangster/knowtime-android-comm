package ca.knowtime.comm.exceptions;

import org.json.JSONException;

public class ParseException
        extends KnowTimeException
{
    private final JSONException mJsonException;


    public ParseException( final JSONException jsonException ) {
        mJsonException = jsonException;
    }


    public JSONException getJsonException() {
        return mJsonException;
    }


    @Override
    public String getMessage() {
        return "KNOWtime Parse Exception: " + mJsonException.getMessage();
    }
}
