package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.cache.CacheableResponse;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.Estimate;
import ca.knowtime.comm.types.Location;
import ca.knowtime.comm.types.StopTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EstimatesParser
        implements JsonParser<List<Estimate>>
{
    private final String mJson;


    public static class Factory
            implements ParserFactory<List<Estimate>>
    {
        @Override
        public JsonParser<List<Estimate>> create( final KnowTimeAccess knowTime, final CacheableResponse res ) {
            return new EstimatesParser( res.getData() );
        }
    }


    public EstimatesParser( final String json ) {
        mJson = json;
    }


    @Override
    public List<Estimate> get() {
        try {
            final JSONArray arr = new JSONArray( mJson );
            final List<Estimate> estimates = new ArrayList<Estimate>( arr.length() );

            for( int i = 0, s = arr.length(); i < s; ++i ) {
                final JSONObject obj = arr.getJSONObject( i );

                final Location loc = parseLocation( obj.getJSONObject( "location" ) );
                final StopTime arrival = StopTime.parse( obj.getString( "estimateArrival" ) );
                estimates.add( new Estimate( loc, obj.getInt( "nextStopNumber" ), arrival ) );
            }
            return estimates;
        } catch( final JSONException e ) {
            throw new ParseException( e );
        }
    }


    private Location parseLocation( final JSONObject object )
            throws JSONException {
        return new Location( (float) object.getDouble( "lat" ), (float) object.getDouble( "lng" ) );
    }
}
