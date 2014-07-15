package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.StopTime;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;


public class StopTimeParser
        extends JsonParser<StopTime, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<StopTime, GtfsAccess>
    {
        protected Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<StopTime, GtfsAccess> parser( final JSONObject res ) {
            return new StopTimeParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<StopTime>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<StopTime>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "stop_times", new Factory( mAccess ), mAccess, res );
        }
    }


    public StopTimeParser( final GtfsAccess access, final JSONObject json ) {
        super( "", access, json );
    }


    @Override
    public StopTime get()
    throws ParseException {
        return new StopTime( mAccess,
                             optIntern( "trip_id" ).get(),
                             opt( "arrival_time" ).get(),
                             opt( "departure_time" ).get(),
                             optIntern( "stop_id" ).get(),
                             optInteger( "stop_sequence" ).get(),
                             opt( "stop_headsign" ),
                             optInteger( "pickup_type" ),
                             optInteger( "drop_off_type" ),
                             optFloat( "shape_dist_traveled" ) );
    }
}
