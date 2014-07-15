package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.Frequency;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class FrequencyParser
        extends JsonParser<Frequency, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<Frequency, GtfsAccess>
    {
        public Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<Frequency, GtfsAccess> parser( final JSONObject res ) {
            return new FrequencyParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<Frequency>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<Frequency>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "frequencies", new Factory( mAccess ), mAccess, res );
        }
    }


    protected FrequencyParser( final GtfsAccess access, final JSONObject json ) {
        super( "", access, json );
    }


    @Override
    public Frequency get()
    throws ParseException {
        return new Frequency( mAccess,
                              opt( "trip_id" ).get(),
                              opt( "start_time" ).get(),
                              opt( "end_time" ).get(),
                              optInteger( "headway_secs" ).get(),
                              optInteger( "exact_times" ) );
    }
}
