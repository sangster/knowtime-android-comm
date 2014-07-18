package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.StopTime;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;


public class StopTimeParser
        extends JsonParser<StopTime>
{
    public static class Factory
            implements ParserFactory<StopTime>
    {
        @Override
        public JsonParser<StopTime> parser( final JSONObject res ) {
            return new StopTimeParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<StopTime>>
    {
        @Override
        public JsonParser<List<StopTime>> parser( final JSONObject res ) {
            return new ListParser<>( "stop_times", new Factory(), res );
        }
    }


    public StopTimeParser( final JSONObject json ) {
        super( "", json );
    }


    @Override
    public StopTime get()
    throws ParseException {
        return new StopTime( optIntern( "trip_id" ).get(),
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
