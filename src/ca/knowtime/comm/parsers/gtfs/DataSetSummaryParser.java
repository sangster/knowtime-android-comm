package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.DataSetSummary;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class DataSetSummaryParser
        extends JsonParser<DataSetSummary, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<DataSetSummary, GtfsAccess>
    {
        public Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<DataSetSummary, GtfsAccess> parser( final JSONObject res ) {
            return new DataSetSummaryParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<DataSetSummary>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<DataSetSummary>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "data_sets", new Factory( mAccess ), mAccess, res );
        }
    }


    public DataSetSummaryParser( final GtfsAccess access, final JSONObject json ) {
        super( "", access, json );
    }


    @Override
    public DataSetSummary get()
    throws ParseException {
        return new DataSetSummary( mAccess,
                                   opt( "id" ).get(),
                                   opt( "name" ).get(),
                                   opt( "url" ).get(),
                                   opt( "etag" ).get(),
                                   opt( "created_at" ).get() );
    }
}
