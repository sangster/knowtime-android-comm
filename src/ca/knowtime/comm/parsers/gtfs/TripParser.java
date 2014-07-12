package ca.knowtime.comm.parsers.gtfs;


import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.Trip;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class TripParser
        extends JsonParser<Trip, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<Trip, GtfsAccess>
    {
        public Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<Trip, GtfsAccess> parser( final JSONObject res ) {
            return new TripParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<Trip>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<Trip>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "trips", new Factory( mAccess ), mAccess, res );
        }
    }


    public TripParser( final GtfsAccess knowTime, final JSONObject json ) {
        super( "trip", knowTime, json );
    }


    @Override
    public Trip get()
    throws ParseException {
        return new Trip( mAccess,
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
