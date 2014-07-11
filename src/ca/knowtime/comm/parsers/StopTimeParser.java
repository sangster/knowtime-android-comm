package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.StopTime;
import org.json.JSONObject;

import java.util.List;


public class StopTimeParser
        extends JsonParser<StopTime>
{
    public static class Factory
            implements ParserFactory<StopTime>
    {
        @Override
        public JsonParser<StopTime> parser( final KnowTimeAccess knowTime, final JSONObject res ) {
            return new StopTimeParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<StopTime>>
    {
        @Override
        public JsonParser<List<StopTime>> parser( final KnowTimeAccess knowTime,
                                                  final JSONObject res ) {
            return new ListParser<>( "stop_times", new Factory(), knowTime, res );
        }
    }


    public StopTimeParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "", knowTime, json );
    }


    @Override
    public StopTime get()
    throws ParseException {
        return new StopTime( unaliasIntern( "trip_id" ).orNull(),
                             unalias( "arrival_time" ).orNull(),
                             unalias( "departure_time" ).orNull(),
                             unaliasIntern( "stop_id" ).orNull(),
                             unaliasInteger( "stop_sequence" ).orNull(),
                             unalias( "stop_headsign" ),
                             unaliasInteger( "pickup_type" ),
                             unaliasInteger( "drop_off_type" ),
                             unaliasFloat( "shape_dist_traveled" ) );
    }
}
