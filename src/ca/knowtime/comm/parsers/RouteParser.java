package ca.knowtime.comm.parsers;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.Route;
import org.json.JSONObject;

import java.util.List;

public class RouteParser
        extends JsonParser<Route>
{
    public static class Factory
            implements ParserFactory<Route>
    {
        @Override
        public JsonParser<Route> parser( final KnowTimeAccess knowTime, final JSONObject res ) {
            return new RouteParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Route>>
    {
        @Override
        public JsonParser<List<Route>> parser( final KnowTimeAccess knowTime,
                                               final JSONObject res ) {
            return new ListParser<>( "routes", new Factory(), knowTime, res );
        }
    }


    public RouteParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "agency", knowTime, json );
    }


    public Route get() {
        return new Route( mKnowTime,
                          unaliasIntern( "id" ).orNull(),
                          unaliasIntern( "short_name" ).orNull(),
                          unaliasIntern( "long_name" ).orNull(),
                          unaliasInteger( "type" ).orNull(),
                          optIntern( "agency_id" ),
                          unalias( "desc" ),
                          unalias( "url" ),
                          unalias( "color" ),
                          unalias( "text_color" ) );
    }
}
