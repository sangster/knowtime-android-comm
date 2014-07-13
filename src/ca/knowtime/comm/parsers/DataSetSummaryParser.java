package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.DataSetSummary;
import com.google.common.base.Optional;
import org.json.JSONObject;

import java.util.List;

public class DataSetSummaryParser
        extends JsonParser<DataSetSummary, KnowTimeAccess>
{
    public static class Factory
            extends ParserFactory<DataSetSummary, KnowTimeAccess>
    {
        public Factory( final KnowTimeAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<DataSetSummary, KnowTimeAccess> parser( final JSONObject res ) {
            return new DataSetSummaryParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<DataSetSummary>, KnowTimeAccess>
    {
        public ListFactory( final KnowTimeAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<DataSetSummary>, KnowTimeAccess> parser( final JSONObject res ) {
            return new ListParser<>( "data_sets", new Factory( mAccess ), mAccess, res );
        }
    }


    public DataSetSummaryParser( final KnowTimeAccess access, final JSONObject json ) {
        super( "", access, json );
    }


    @Override
    public DataSetSummary get()
    throws ParseException {
        return new DataSetSummary( mAccess,
                                   opt( "id" ).orNull(),
                                   opt( "name" ).orNull(),
                                   opt( "last_updated" ).orNull(),
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
