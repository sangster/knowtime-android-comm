package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.FareRule;
import org.json.JSONObject;

import java.util.List;

public class FareRuleParser
        extends JsonParser<FareRule>
{
    public static class Factory
            implements ParserFactory<FareRule>
    {
        @Override
        public JsonParser<FareRule> parser( final KnowTimeAccess knowTime, final JSONObject res ) {
            return new FareRuleParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<FareRule>>
    {
        @Override
        public JsonParser<List<FareRule>> parser( final KnowTimeAccess knowTime,
                                                  final JSONObject res ) {
            return new ListParser<>( "fare_rules", new Factory(), knowTime, res );
        }
    }


    protected FareRuleParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "", knowTime, json );
    }


    @Override
    public FareRule get()
    throws ParseException {
        return new FareRule( mKnowTime,
                             opt( "fare_id" ).orNull(),
                             opt( "route_id" ),
                             opt( "origin_id" ),
                             opt( "destination_id" ),
                             opt( "contains_id" ) );
    }
}
