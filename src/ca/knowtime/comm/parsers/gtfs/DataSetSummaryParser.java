package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.DataSetSummary;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class DataSetSummaryParser
        extends JsonParser<DataSetSummary>
{
    public static class Factory
            implements ParserFactory<DataSetSummary>
    {
        @Override
        public JsonParser<DataSetSummary> parser( final JSONObject res ) {
            return new DataSetSummaryParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<DataSetSummary>>
    {
        @Override
        public JsonParser<List<DataSetSummary>> parser( final JSONObject res ) {
            return new ListParser<>( "data_sets", new Factory(), res );
        }
    }


    public DataSetSummaryParser( final JSONObject json ) {
        super( "", json );
    }


    @Override
    public DataSetSummary get()
    throws ParseException {
        return new DataSetSummary( opt( "id" ).get(),
                                   opt( "name" ).get(),
                                   opt( "url" ).get(),
                                   opt( "etag" ).get(),
                                   opt( "created_at" ).get() );
    }
}
