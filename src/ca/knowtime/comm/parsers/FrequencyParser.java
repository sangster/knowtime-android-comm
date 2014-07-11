package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.Frequency;
import org.json.JSONObject;

import java.util.List;

public class FrequencyParser
        extends JsonParser<Frequency>
{
    public static class Factory
            implements ParserFactory<Frequency>
    {
        @Override
        public JsonParser<Frequency> parser( final KnowTimeAccess knowTime, final JSONObject res ) {
            return new FrequencyParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Frequency>>
    {
        @Override
        public JsonParser<List<Frequency>> parser( final KnowTimeAccess knowTime,
                                                   final JSONObject res ) {
            return new ListParser<>( "frequencies", new Factory(), knowTime, res );
        }
    }


    protected FrequencyParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "", knowTime, json );
    }


    @Override
    public Frequency get()
    throws ParseException {
        return new Frequency( mKnowTime,
                              opt( "trip_id" ).orNull(),
                              opt( "start_time" ).orNull(),
                              opt( "end_time" ).orNull(),
                              optInteger( "headway_secs" ).orNull(),
                              optInteger( "exact_times" ) );
    }
}
