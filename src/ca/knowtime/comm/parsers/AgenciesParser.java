package ca.knowtime.comm.parsers;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.Agency;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AgenciesParser
        implements JsonParser<List<Agency>>
{
    private final KnowTimeAccess mKnowTime;
    private final JSONObject mJson;


    public static class Factory
            implements ParserFactory<List<Agency>>
    {
        @Override
        public JsonParser<List<Agency>> create( final KnowTimeAccess knowTime,
                                                final JSONObject res ) {
            return new AgenciesParser( knowTime, res );
        }
    }


    public AgenciesParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        mKnowTime = knowTime;
        mJson = json;
    }


    public List<Agency> get() {
        try {
            final List<Agency> agencies = new ArrayList<>();

            final JSONArray arr = mJson.getJSONArray( "agencies" );
            for( int i = 0, s = arr.length(); i < s; ++i ) {
                final JSONObject obj = arr.getJSONObject( i );

                agencies.add( new Agency( obj.getString( "name" ),
                                          obj.getString( "url" ),
                                          obj.getString( "timezone" ),
                                          obj.getString( "lang" ) ) );
            }
            return agencies;
        } catch( final JSONException e ) {
            throw new ParseException( e );
        }
    }
}
