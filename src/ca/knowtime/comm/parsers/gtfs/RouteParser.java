package ca.knowtime.comm.parsers.gtfs;


import ca.knowtime.comm.models.gtfs.Route;
import ca.knowtime.comm.models.gtfs.enums.RouteType;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class RouteParser
        extends JsonParser<Route>
{
    public static class Factory
            implements ParserFactory<Route>
    {
        @Override
        public JsonParser<Route> parser( final JSONObject res ) {
            return new RouteParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Route>>
    {
        @Override
        public JsonParser<List<Route>> parser( final JSONObject res ) {
            return new ListParser<>( "routes", new Factory(), res );
        }
    }


    public RouteParser( final JSONObject json ) {
        super( json );
    }


    public Route get() {
        return new Route( optIntern( "route_id" ).get(),
                          optIntern( "route_short_name" ).get(),
                          optIntern( "route_long_name" ).get(),
                          optRouteType(),
                          optIntern( "route_agency_id" ),
                          opt( "route_desc" ),
                          opt( "route_url" ),
                          opt( "route_color" ),
                          opt( "route_text_color" ) );
    }


    private RouteType optRouteType() {
        final Integer type = optInteger( "route_type" ).get();
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
