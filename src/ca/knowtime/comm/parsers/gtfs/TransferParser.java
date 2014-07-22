package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.Transfer;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class TransferParser
        extends JsonParser<Transfer>
{
    public static class Factory
            implements ParserFactory<Transfer>
    {
        @Override
        public JsonParser<Transfer> parser( final JSONObject res ) {
            return new TransferParser( res );
        }
    }


    public static class ListFactory
            implements ParserFactory<List<Transfer>>
    {
        @Override
        public JsonParser<List<Transfer>> parser( final JSONObject res ) {
            return new ListParser<>( "transfers", new Factory(), res );
        }
    }


    public TransferParser( final JSONObject json ) {
        super( json );
    }


    @Override
    public Transfer get()
    throws ParseException {
        return new Transfer( opt( "from_stop_id" ).get(),
                             opt( "to_stop_id" ).get(),
                             optInteger( "transfer_type" ).get(),
                             optInteger( "min_transfer_time" ) );
    }
}
