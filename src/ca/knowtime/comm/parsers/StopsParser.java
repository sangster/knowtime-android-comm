package ca.knowtime.comm.parsers;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.Location;
import ca.knowtime.comm.types.Stop;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StopsParser
        implements JsonParser<List<Stop>>
{
    private final KnowTimeAccess mKnowTime;
    private final JSONObject mJson;


    public static class Factory
            implements ParserFactory<List<Stop>>
    {
        @Override
        public JsonParser<List<Stop>> create( final KnowTimeAccess knowTime,
                                              final JSONObject res ) {
            return new StopsParser( knowTime, res );
        }
    }


    public StopsParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        mKnowTime = knowTime;
        mJson = json;
    }


    public List<Stop> get() {
        try {
            final List<Stop> stops = new ArrayList<>();

            final JSONArray arr = mJson.getJSONArray( "stops" );
            for( int i = 0, s = arr.length(); i < s; ++i ) {
                final JSONObject obj = arr.getJSONObject( i );
                final JSONObject locObj = obj.getJSONObject( "location" );

                final Location location = new Location( (float) locObj.getDouble( "lat" ),
                                                        (float) locObj.getDouble( "lng" ) );

                stops.add( new Stop( mKnowTime,
                                     obj.getInt( "stopNumber" ),
                                     obj.getString( "name" ),
                                     location ) );
            }
            return stops;
        } catch( final JSONException e ) {
            throw new ParseException( e );
        }
    }
}
