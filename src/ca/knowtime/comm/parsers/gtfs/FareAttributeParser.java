package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.FareAttribute;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class FareAttributeParser
        extends JsonParser<FareAttribute, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<FareAttribute, GtfsAccess>
    {
        public Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<FareAttribute, GtfsAccess> parser( final JSONObject res ) {
            return new FareAttributeParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<FareAttribute>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<FareAttribute>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "fare_attributes", new Factory( mAccess ), mAccess, res );
        }
    }


    public FareAttributeParser( final GtfsAccess access, final JSONObject json ) {
        super( "", access, json );
    }


    @Override
    public FareAttribute get()
    throws ParseException {
        return new FareAttribute( mAccess,
                                  optIntern( "fare_id" ).orNull(),
                                  opt( "price" ).orNull(),
                                  opt( "currency_type" ).orNull(),
                                  optInteger( "payment_method" ).orNull(),
                                  optInteger( "transfers" ).orNull(),
                                  optInteger( "transfer_duration" ) );
    }
}
