package ca.knowtime.comm.parsers.gtfs;


import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.Trip;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class TripParser
        extends JsonParser<Trip>
{
    public static class Factory
            implements ParserFactory<Trip>
    {
        @Override
        public JsonParser<Trip> parser( final JSONObject res ) {
            return new TripParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Trip>>
    {
        @Override
        public JsonParser<List<Trip>> parser( final JSONObject res ) {
            return new ListParser<>( "trips", new Factory(), res );
        }
    }


    public TripParser( final JSONObject json ) {
        super( "trip", json );
    }


    @Override
    public Trip get()
    throws ParseException {
        return new Trip( unaliasIntern( "id" ).get(),
                         optIntern( "route_id" ).get(),
                         optIntern( "service_id" ).get(),
                         unalias( "headsign" ),
                         unalias( "short_name" ),
                         optInteger( "direction_id" ),
                         optIntern( "block_id" ),
                         optIntern( "shape_id" ),
                         optInteger( "wheelchair_accessible" ),
                         optInteger( "bikes_allowed" ) );
    }
}
