package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.cache.CacheableResponse;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.RouteName;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RouteNamesParser
        implements JsonParser<List<RouteName>>
{
    private final String mJson;


    public static class Factory
            implements ParserFactory<List<RouteName>>
    {
        @Override
        public JsonParser<List<RouteName>> create( final KnowTimeAccess knowTime, final CacheableResponse res ) {
            return new RouteNamesParser( res.getData() );
        }
    }


    public RouteNamesParser( final String json ) {
        mJson = json;
    }


    @Override
    public List<RouteName> get() {
        try {
            final JSONArray array = new JSONArray( mJson );
            final List<RouteName> names = new ArrayList<RouteName>( array.length() );
            for( int i = 0, s = array.length(); i < s; ++i ) {
                final JSONObject obj = array.getJSONObject( i );

                names.add( new RouteName( obj.getString( "shortName" ), obj.getString( "longName" ) ) );
            }
            return names;
        } catch( final JSONException e ) {
            throw new ParseException( e );
        }
    }
}
