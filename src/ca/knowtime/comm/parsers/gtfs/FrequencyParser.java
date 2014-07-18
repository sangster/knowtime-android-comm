package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.Frequency;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class FrequencyParser
        extends JsonParser<Frequency>
{
    public static class Factory
            implements ParserFactory<Frequency>
    {
        @Override
        public JsonParser<Frequency> parser( final JSONObject res ) {
            return new FrequencyParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Frequency>>
    {
        @Override
        public JsonParser<List<Frequency>> parser( final JSONObject res ) {
            return new ListParser<>( "frequencies", new Factory(), res );
        }
    }


    protected FrequencyParser( final JSONObject json ) {
        super( "", json );
    }


    @Override
    public Frequency get()
    throws ParseException {
        return new Frequency( opt( "trip_id" ).get(),
                              opt( "start_time" ).get(),
                              opt( "end_time" ).get(),
                              optInteger( "headway_secs" ).get(),
                              optInteger( "exact_times" ) );
    }
}
