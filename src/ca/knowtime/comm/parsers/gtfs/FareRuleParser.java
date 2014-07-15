package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.FareRule;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class FareRuleParser
        extends JsonParser<FareRule, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<FareRule, GtfsAccess>
    {
        public Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<FareRule, GtfsAccess> parser( final JSONObject res ) {
            return new FareRuleParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<FareRule>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<FareRule>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "fare_rules", new Factory( mAccess ), mAccess, res );
        }
    }


    protected FareRuleParser( final GtfsAccess access, final JSONObject json ) {
        super( "", access, json );
    }


    @Override
    public FareRule get()
    throws ParseException {
        return new FareRule( mAccess,
                             opt( "fare_id" ).get(),
                             opt( "route_id" ),
                             opt( "origin_id" ),
                             opt( "destination_id" ),
                             opt( "contains_id" ) );
    }
}
