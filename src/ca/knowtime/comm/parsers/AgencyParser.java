package ca.knowtime.comm.parsers;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.Agency;
import org.json.JSONObject;

import java.util.List;

public class AgencyParser
        extends JsonParser<Agency>
{
    public static class Factory
            implements ParserFactory<Agency>
    {
        @Override
        public JsonParser<Agency> parser( final KnowTimeAccess knowTime, final JSONObject res ) {
            return new AgencyParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Agency>>
    {
        @Override
        public JsonParser<List<Agency>> parser( final KnowTimeAccess knowTime,
                                                final JSONObject res ) {
            return new ListParser<>( "agencies", new Factory(), knowTime, res );
        }
    }


    public AgencyParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "agency", knowTime, json );
    }


    public Agency get() {
        return new Agency( unalias( "name" ).orNull(),
                           unalias( "url" ).orNull(),
                           unalias( "timezone" ).orNull(),
                           unaliasIntern( "id" ),
                           unalias( "lang" ),
                           unalias( "phone" ),
                           unalias( "fare_url" ) );
    }
}
