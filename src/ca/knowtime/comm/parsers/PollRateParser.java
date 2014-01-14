package ca.knowtime.comm.parsers;

import org.json.JSONException;
import org.json.JSONObject;

public class PollRateParser
        implements JsonParser<Float>
{
    private final String mJson;


    public PollRateParser( final String json ) {
        mJson = json;
    }


    @Override
    public Float get()
            throws JSONException {
        return (float) new JSONObject( mJson ).getDouble( "rate" );
    }
}
