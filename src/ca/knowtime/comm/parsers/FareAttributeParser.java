package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.FareAttribute;
import org.json.JSONObject;

import java.util.List;

public class FareAttributeParser
        extends JsonParser<FareAttribute>
{
    public static class Factory
            implements ParserFactory<FareAttribute>
    {
        @Override
        public JsonParser<FareAttribute> parser( final KnowTimeAccess knowTime,
                                                 final JSONObject res ) {
            return new FareAttributeParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<FareAttribute>>
    {
        @Override
        public JsonParser<List<FareAttribute>> parser( final KnowTimeAccess knowTime,
                                                       final JSONObject res ) {
            return new ListParser<>( "fare_attributes", new Factory(), knowTime, res );
        }
    }


    public FareAttributeParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "", knowTime, json );
    }


    @Override
    public FareAttribute get()
    throws ParseException {
        return new FareAttribute( mKnowTime,
                                  optIntern( "fare_id" ).orNull(),
                                  opt( "price" ).orNull(),
                                  opt( "currency_type" ).orNull(),
                                  optInteger( "payment_method" ).orNull(),
                                  optInteger( "transfers" ).orNull(),
                                  optInteger( "transfer_duration" ) );
    }
}
