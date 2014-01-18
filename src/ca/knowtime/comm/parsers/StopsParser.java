package ca.knowtime.comm.parsers;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.cache.CacheableResponse;
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
    private final String mJson;


    public static class Factory
            implements ParserFactory<List<Stop>>
    {
        @Override
        public JsonParser<List<Stop>> create( final KnowTimeAccess knowTime, final CacheableResponse res ) {
            return new StopsParser( knowTime, res.getData() );
        }
    }


    public StopsParser( final KnowTimeAccess knowTime, final String json ) {
        mKnowTime = knowTime;
        mJson = json;
    }


    public List<Stop> get() {
        try {
            final List<Stop> stops = new ArrayList<Stop>();
            final JSONArray array = new JSONArray( mJson );

            for( int i = 0, s = array.length(); i < s; ++i ) {
                final JSONObject obj = array.getJSONObject( i );
                final JSONObject locObj = obj.getJSONObject( "location" );

                final Location location = new Location( (float) locObj.getDouble( "lat" ),
                                                        (float) locObj.getDouble( "lng" ) );

                stops.add( new Stop( mKnowTime, obj.getInt( "stopNumber" ), obj.getString( "name" ), location ) );
            }
            return stops;
        } catch( final JSONException e ) {
            throw new ParseException( e );
        }
    }
}
