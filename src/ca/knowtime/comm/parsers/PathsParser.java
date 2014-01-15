package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.cache.CacheableResponse;
import ca.knowtime.comm.types.Location;
import ca.knowtime.comm.types.Path;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PathsParser
        implements JsonParser<List<Path>>
{
    private final String mJson;


    public static class Factory
            implements ParserFactory<List<Path>>
    {
        @Override
        public JsonParser<List<Path>> create( final KnowTimeAccess knowTime, final CacheableResponse res ) {
            return new PathsParser( res.getData() );
        }
    }


    public PathsParser( final String json ) {
        mJson = json;
    }


    @Override
    public List<Path> get()
            throws JSONException {
        final JSONArray arr = new JSONArray( mJson );
        final List<Path> paths = new ArrayList<Path>( arr.length() );

        for( int i = 0, s = arr.length(); i < s; ++i ) {
            paths.add( parsePath( arr.getJSONObject( i ) ) );
        }
        return paths;
    }


    private Path parsePath( final JSONObject pathObj )
            throws JSONException {
        final JSONArray pathPoints = pathObj.getJSONArray( "pathPoints" );
        final List<Location> points = new ArrayList<Location>( pathPoints.length() );

        for( int i = 0, s = pathPoints.length(); i < s; ++i ) {
            points.add( parseLocation( pathPoints.getJSONObject( i ) ) );
        }

        return new Path( UUID.fromString( pathObj.getString( "pathId" ) ), points );
    }


    private Location parseLocation( final JSONObject obj )
            throws JSONException {
        return new Location( (float) obj.getDouble( "lat" ), (float) obj.getDouble( "lng" ) );
    }
}
