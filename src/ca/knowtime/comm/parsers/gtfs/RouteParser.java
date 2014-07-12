package ca.knowtime.comm.parsers.gtfs;


import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.models.gtfs.Route;
import ca.knowtime.comm.models.gtfs.enums.RouteType;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class RouteParser
        extends JsonParser<Route, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<Route, GtfsAccess>
    {
        public Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<Route, GtfsAccess> parser( final JSONObject res ) {
            return new RouteParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<Route>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<Route>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "routes", new Factory( mAccess ), mAccess, res );
        }
    }


    public RouteParser( final GtfsAccess access, final JSONObject json ) {
        super( "agency", access, json );
    }


    public Route get() {
        return new Route( mAccess,
                          unaliasIntern( "id" ).orNull(),
                          unaliasIntern( "short_name" ).orNull(),
                          unaliasIntern( "long_name" ).orNull(),
                          unaliasRouteType(),
                          optIntern( "agency_id" ),
                          unalias( "desc" ),
                          unalias( "url" ),
                          unalias( "color" ),
                          unalias( "text_color" ) );
    }


    private RouteType unaliasRouteType() {
        final Integer type = unaliasInteger( "type" ).get();
        switch( type ) {
            case 0:
                return RouteType.tram;
            case 1:
                return RouteType.subway;
            case 2:
                return RouteType.rail;
            case 3:
                return RouteType.bus;
            case 4:
                return RouteType.ferry;
            case 5:
                return RouteType.cableCar;
            case 6:
                return RouteType.gondola;
            case 7:
                return RouteType.funicular;
            default:
                throw new IllegalArgumentException( "Unknown route type: " + type );
        }
    }
}
