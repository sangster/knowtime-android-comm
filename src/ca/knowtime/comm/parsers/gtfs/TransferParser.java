package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.Transfer;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class TransferParser
        extends JsonParser<Transfer, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<Transfer, GtfsAccess>
    {
        protected Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<Transfer, GtfsAccess> parser( final JSONObject res ) {
            return new TransferParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<Transfer>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<Transfer>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "transfers", new Factory( mAccess ), mAccess, res );
        }
    }


    public TransferParser( final GtfsAccess access, final JSONObject json ) {
        super( "", access, json );
    }


    @Override
    public Transfer get()
    throws ParseException {
        return new Transfer( mAccess,
                             opt( "from_stop_id" ).orNull(),
                             opt( "to_stop_id" ).orNull(),
                             optInteger( "transfer_type" ).orNull(),
                             optInteger( "min_transfer_time" ) );
    }
}
