package ca.knowtime.comm.parsers;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.Stop;
import org.json.JSONObject;

import java.util.List;

public class StopsParser
        extends JsonParser<Stop>
{
    public static class Factory
            implements ParserFactory<Stop>
    {
        @Override
        public JsonParser<Stop> parser( final KnowTimeAccess knowTime, final JSONObject res ) {
            return new StopsParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Stop>>
    {
        @Override
        public JsonParser<List<Stop>> parser( final KnowTimeAccess knowTime,
                                              final JSONObject res ) {
            return new ListParser<>( "stops", new Factory(), knowTime, res );
        }
    }


    public StopsParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "stop", knowTime, json );
    }


    public Stop get() {
        return new Stop( mKnowTime,
                         unalias( "id" ).orNull(),
                         unalias( "name" ).orNull(),
                         unaliasFloat( "lat" ).orNull(),
                         unaliasFloat( "lon" ).orNull(),
                         unalias( "code" ),
                         unalias( "desc" ),
                         opt( "zone_id" ),
                         unalias( "url" ),
                         optInteger( "location_type" ),
                         optInteger( "parent_station" ),
                         unalias( "timezone" ),
                         optInteger( "wheelchair_boarding" ) );
    }
}
