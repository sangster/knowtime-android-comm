package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.DataSetSummary;
import org.json.JSONObject;

import java.util.List;

public class DataSetSummariesParser
        extends JsonParser<DataSetSummary>
{
    public static class Factory
            implements ParserFactory<DataSetSummary>
    {
        @Override
        public JsonParser<DataSetSummary> parser( final KnowTimeAccess knowTime,
                                                  final JSONObject res ) {
            return new DataSetSummariesParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<DataSetSummary>>
    {
        @Override
        public JsonParser<List<DataSetSummary>> parser( final KnowTimeAccess knowTime,
                                                        final JSONObject res ) {
            return new ListParser<>( "data_sets", new Factory(), knowTime, res );
        }
    }


    public DataSetSummariesParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "", knowTime, json );
    }


    @Override
    public DataSetSummary get()
    throws ParseException {
        return new DataSetSummary( mKnowTime,
                                   opt( "id" ).orNull(),
                                   opt( "name" ).orNull(),
                                   opt( "url" ).orNull(),
                                   opt( "etag" ).orNull(),
                                   opt( "created_at" ).orNull() );
    }
}
