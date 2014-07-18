package ca.knowtime.comm.parsers;


import ca.knowtime.comm.exceptions.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListParser<T>
        extends JsonParser<List<T>>
{
    private final String mCollectionKey;
    private final ParserFactory<T> mElementFactory;


    public ListParser( final String collectionKey,
                       final ParserFactory<T> elementFactory,
                       final JSONObject json ) {
        super( "", json );
        mCollectionKey = collectionKey;
        mElementFactory = elementFactory;
    }


    @Override
    public List<T> get()
    throws ParseException {
        final List<T> collection = new ArrayList<>();
        final JSONArray arr = getJSONArray();

        for( int i = 0, s = arr.length(); i < s; ++i ) {
            collection.add( mElementFactory.parser( getJSONObject( arr, i ) )
                                           .get() );
        }
        return collection;
    }


    private JSONArray getJSONArray() {
        try {
            return mJson.getJSONArray( mCollectionKey );
        } catch( JSONException e ) {
            return new JSONArray();
        }
    }


    private JSONObject getJSONObject( final JSONArray arr, final int i ) {
        try {
            return arr.getJSONObject( i );
        } catch( JSONException e ) {
            return new JSONObject();
        }
    }
}
