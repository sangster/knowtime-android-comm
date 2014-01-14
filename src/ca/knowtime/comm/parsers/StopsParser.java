package ca.knowtime.comm.parsers;


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
    private final String mJson;


    public StopsParser( final String json ) {
        mJson = json;
    }


    public List<Stop> get()
            throws JSONException {
        final List<Stop> stops = new ArrayList<Stop>();
        final JSONArray array = new JSONArray( mJson );

        for( int i = 0, s = array.length(); i < s; ++i ) {
            final JSONObject obj = array.getJSONObject( i );
            final JSONObject locObj = obj.getJSONObject( "location" );

            final Location location = new Location( (float) locObj.getDouble( "lat" ),
                                                    (float) locObj.getDouble( "lng" ) );

            stops.add( new Stop( obj.getInt( "stopNumber" ), obj.getString( "name" ), location ) );
        }

        return stops;
    }
}
