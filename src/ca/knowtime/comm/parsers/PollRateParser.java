package ca.knowtime.comm.parsers;

import ca.knowtime.comm.exceptions.ParseException;
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
    public Float get() {
        try {
            return (float) new JSONObject( mJson ).getDouble( "rate" );
        } catch( final JSONException e ) {
            throw new ParseException( e );
        }
    }
}
