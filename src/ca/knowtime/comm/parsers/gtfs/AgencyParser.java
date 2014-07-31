package ca.knowtime.comm.parsers.gtfs;


import ca.knowtime.comm.models.gtfs.Agency;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class AgencyParser
        extends JsonParser<Agency>
{
    public static class Factory
            implements ParserFactory<Agency>
    {
        @Override
        public JsonParser<Agency> parser( final JSONObject res ) {
            return new AgencyParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Agency>>
    {
        @Override
        public JsonParser<List<Agency>> parser( final JSONObject res ) {
            return new ListParser<>( "agencies", new Factory(), res );
        }
    }


    public AgencyParser( final JSONObject json ) {
        super( json );
    }


    public Agency get() {
        return new Agency( opt( "agency_name" ).get(),
                           opt( "agency_url" ).get(),
                           opt( "agency_timezone" ).get(),
                           optIntern( "agency_id" ),
                           opt( "agency_lang" ),
                           opt( "agency_phone" ),
                           opt( "agency_fare_url" ) );
    }
}
