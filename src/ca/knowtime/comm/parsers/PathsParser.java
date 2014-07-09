package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
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
    private final JSONObject mJson;


    public static class FactoryObject
            implements ParserFactory<List<Path>>
    {
        @Override
        public JsonParser<List<Path>> create( final KnowTimeAccess knowTime,
                                              final JSONObject res ) {
            return new PathsParser( res );
        }
    }


    public PathsParser( final JSONObject json ) {
        mJson = json;
    }


    @Override
    public List<Path> get() {
        try {
            final JSONArray arr = mJson.getJSONArray( "paths" );
            final List<Path> paths = new ArrayList<>( arr.length() );

            for( int i = 0, s = arr.length(); i < s; ++i ) {
                paths.add( parsePath( arr.getJSONObject( i ) ) );
            }
            return paths;
        } catch( final JSONException e ) {
            throw new ParseException( e );
        }
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
