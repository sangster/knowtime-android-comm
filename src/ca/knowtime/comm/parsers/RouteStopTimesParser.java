package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.cache.CacheableResponse;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.RouteStopTimes;
import ca.knowtime.comm.types.StopTime;
import ca.knowtime.comm.types.StopTimePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RouteStopTimesParser
        implements JsonParser<List<RouteStopTimes>>
{
    private final String mJson;


    public static class Factory
            implements ParserFactory<List<RouteStopTimes>>
    {
        @Override
        public JsonParser<List<RouteStopTimes>> create( final KnowTimeAccess knowTime, final CacheableResponse res ) {
            return new RouteStopTimesParser( res.getData() );
        }
    }


    public RouteStopTimesParser( final String json ) {
        mJson = json;
    }


    @Override
    public List<RouteStopTimes> get() {
        try {
            final JSONArray arr = new JSONArray( mJson );
            final List<RouteStopTimes> stopTimes = new ArrayList<RouteStopTimes>( arr.length() );

            for( int i = 0, s = arr.length(); i < s; ++i ) {
                stopTimes.add( getRouteStopTimes( arr.getJSONObject( i ) ) );
            }
            return stopTimes;
        } catch( final JSONException e ) {
            throw new ParseException( e );
        }
    }


    private RouteStopTimes getRouteStopTimes( final JSONObject obj )
            throws JSONException {
        final UUID routeId = UUID.fromString( obj.getString( "routeId" ) );
        final String shortName = obj.getString( "shortName" );
        final String longName = obj.getString( "longName" );
        final List<StopTimePair> stopTimes = parseStopTimes( obj.getJSONArray( "stopTimes" ) );

        return new RouteStopTimes( routeId, shortName, longName, stopTimes );
    }


    private List<StopTimePair> parseStopTimes( final JSONArray array )
            throws JSONException {
        final List<StopTimePair> stopTimes = new ArrayList<StopTimePair>( array.length() );

        for( int i = 0, s = array.length(); i < s; ++i ) {
            final JSONObject pair = array.getJSONObject( i );
            stopTimes.add( new StopTimePair( StopTime.parse( pair.getString( "arrival" ) ),
                                             StopTime.parse( pair.getString( "departure" ) ) ) );
        }
        return stopTimes;
    }
}
