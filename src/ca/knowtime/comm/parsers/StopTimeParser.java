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
        return new StopTime( mKnowTime,
                             optIntern( "trip_id" ).orNull(),
                             opt( "arrival_time" ).orNull(),
                             opt( "departure_time" ).orNull(),
                             optIntern( "stop_id" ).orNull(),
                             optInteger( "stop_sequence" ).orNull(),
                             opt( "stop_headsign" ),
                             optInteger( "pickup_type" ),
                             optInteger( "drop_off_type" ),
                             optFloat( "shape_dist_traveled" ) );
    }
}
