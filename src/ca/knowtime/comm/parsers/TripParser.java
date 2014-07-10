package ca.knowtime.comm.parsers;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.Trip;
import org.json.JSONObject;

import java.util.List;

public class TripParser
        extends JsonParser<Trip>
{
    public static class Factory
            implements ParserFactory<Trip>
    {
        @Override
        public JsonParser<Trip> parser( final KnowTimeAccess knowTime, final JSONObject res ) {
            return new TripParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Trip>>
    {
        @Override
        public JsonParser<List<Trip>> parser( final KnowTimeAccess knowTime,
                                              final JSONObject res ) {
            return new ListParser<>( "trips", new Factory(), knowTime, res );
        }
    }


    public TripParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "trip", knowTime, json );
    }


    @Override
    public Trip get()
    throws ParseException {
        return new Trip( mKnowTime,
                         unaliasIntern( "id" ).orNull(),
                         optIntern( "route_id" ).orNull(),
                         optIntern( "service_id" ).orNull(),
                         unalias( "headsign" ),
                         unalias( "short_name" ),
                         optInteger( "direction_id" ),
                         optIntern( "block_id" ),
                         optIntern( "shape_id" ),
                         optInteger( "wheelchair_accessible" ),
                         optInteger( "bikes_allowed" ) );
    }
}
