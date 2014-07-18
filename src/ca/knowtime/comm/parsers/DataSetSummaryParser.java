package ca.knowtime.comm.parsers;

import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.DataSetSummary;
import com.google.common.base.Optional;
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
                                   opt( "title" ).get(),
                                   opt( "last_updated" ).get(),
                                   location( "min" ),
                                   location( "max" ),
                                   optDate( "start" ),
                                   optDate( "end" ) );
    }


    private Optional<String> optDate( final String key ) {
        if( !mJson.has( "dates" ) ) {
            return Optional.absent();
        }
        return Optional.of( mJson.optJSONObject( "dates" ).optString( key ) );
    }


    private DataSetSummary.Location location( final String key ) {
        final JSONObject obj = mJson.optJSONObject( key );
        return new DataSetSummary.Location( (float) obj.optDouble( "lat" ),
                                            (float) obj.optDouble( "lon" ) );
    }
}
