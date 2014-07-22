package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.FareRule;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class FareRuleParser
        extends JsonParser<FareRule>
{
    public static class Factory
            implements ParserFactory<FareRule>
    {
        @Override
        public JsonParser<FareRule> parser( final JSONObject res ) {
            return new FareRuleParser( res );
        }
    }


    public static class ListFactory
            implements ParserFactory<List<FareRule>>
    {
        @Override
        public JsonParser<List<FareRule>> parser( final JSONObject res ) {
            return new ListParser<>( "fare_rules", new Factory(), res );
        }
    }


    protected FareRuleParser( final JSONObject json ) {
        super( json );
    }


    @Override
    public FareRule get()
    throws ParseException {
        return new FareRule( optIntern( "fare_id" ).get(),
                             optIntern( "route_id" ),
                             optIntern( "origin_id" ),
                             optIntern( "destination_id" ),
                             optIntern( "contains_id" ) );
    }
}
