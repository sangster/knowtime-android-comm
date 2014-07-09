package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.DataSetSummary;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataSetSummariesParser
        implements JsonParser<List<DataSetSummary>>
{
    private final KnowTimeAccess mKnowTime;
    private final JSONObject mJson;


    public static class Factory
            implements ParserFactory<List<DataSetSummary>>
    {
        @Override
        public JsonParser<List<DataSetSummary>> create( final KnowTimeAccess knowTime,
                                                        final JSONObject res ) {
            return new DataSetSummariesParser( knowTime, res );
        }
    }


    public DataSetSummariesParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        mKnowTime = knowTime;
        mJson = json;
    }


    @Override
    public List<DataSetSummary> get()
    throws ParseException {
        try {
            final JSONArray arr = mJson.getJSONArray( "data_sets" );
            final List<DataSetSummary> summaries = new ArrayList<>( arr.length() );
            for( int i = 0, s = arr.length(); i < s; ++i ) {
                final JSONObject obj = arr.getJSONObject( i );
                summaries.add( new DataSetSummary( mKnowTime,
                                                   obj.getInt( "id" ),
                                                   obj.getString( "name" ),
                                                   obj.getString( "url" ),
                                                   obj.getString( "etag" ),
                                                   obj.getString( "created_at" ) ) );
            }
            return summaries;
        } catch( final JSONException e ) {
            throw new ParseException( e );
        }
    }
}
