package ca.knowtime.comm.parsers.gtfs;


import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.models.gtfs.Agency;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class AgencyParser
        extends JsonParser<Agency, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<Agency, GtfsAccess>
    {
        protected Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<Agency, GtfsAccess> parser( final JSONObject res ) {
            return new AgencyParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<Agency>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<Agency>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "agencies", new Factory( mAccess ), mAccess, res );
        }
    }


    public AgencyParser( final GtfsAccess access, final JSONObject json ) {
        super( "agency", access, json );
    }


    public Agency get() {
        return new Agency( mAccess,
                           unalias( "name" ).orNull(),
                           unalias( "url" ).orNull(),
                           unalias( "timezone" ).orNull(),
                           unaliasIntern( "id" ),
                           unalias( "lang" ),
                           unalias( "phone" ),
                           unalias( "fare_url" ) );
    }
}
