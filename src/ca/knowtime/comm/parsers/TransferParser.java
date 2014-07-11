package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.Transfer;
import org.json.JSONObject;

import java.util.List;

public class TransferParser
        extends JsonParser<Transfer>
{
    public static class Factory
            implements ParserFactory<Transfer>
    {
        @Override
        public JsonParser<Transfer> parser( final KnowTimeAccess knowTime, final JSONObject res ) {
            return new TransferParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Transfer>>
    {
        @Override
        public JsonParser<List<Transfer>> parser( final KnowTimeAccess knowTime,
                                                  final JSONObject res ) {
            return new ListParser<>( "transfers", new Factory(), knowTime, res );
        }
    }


    public TransferParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "", knowTime, json );
    }


    @Override
    public Transfer get()
    throws ParseException {
        return new Transfer( mKnowTime,
                             opt( "from_stop_id" ).orNull(),
                             opt( "to_stop_id" ).orNull(),
                             optInteger( "transfer_type" ).orNull(),
                             optInteger( "min_transfer_time" ) );
    }
}
