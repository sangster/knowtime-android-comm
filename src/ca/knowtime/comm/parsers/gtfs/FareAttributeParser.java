package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.FareAttribute;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class FareAttributeParser
        extends JsonParser<FareAttribute>
{
    public static class Factory
            implements ParserFactory<FareAttribute>
    {
        @Override
        public JsonParser<FareAttribute> parser( final JSONObject res ) {
            return new FareAttributeParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<FareAttribute>>
    {
        @Override
        public JsonParser<List<FareAttribute>> parser( final JSONObject res ) {
            return new ListParser<>( "fare_attributes", new Factory(), res );
        }
    }


    public FareAttributeParser( final JSONObject json ) {
        super( "", json );
    }


    @Override
    public FareAttribute get()
    throws ParseException {
        return new FareAttribute( optIntern( "fare_id" ).get(),
                                  opt( "price" ).get(),
                                  opt( "currency_type" ).get(),
                                  optInteger( "payment_method" ).get(),
                                  optInteger( "transfers" ).get(),
                                  optInteger( "transfer_duration" ) );
    }
}
