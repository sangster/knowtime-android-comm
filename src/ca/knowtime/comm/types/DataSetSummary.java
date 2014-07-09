package ca.knowtime.comm.types;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class DataSetSummary
        implements KnowtimeModel
{
    private final KnowTimeAccess mKnowTime;
    final int mId;
    final String mName;
    final String mUrl;
    final String mEtag;
    final String mCreatedAt;


    public DataSetSummary( final KnowTimeAccess knowTime, final int id, final String name,
                           final String url, final String etag, final String createdAt ) {
        mKnowTime = knowTime;
        mId = id;
        mName = name;
        mUrl = url;
        mEtag = etag;
        mCreatedAt = createdAt;
    }


    public void agencies( Response<List<Agency>> response ) {
        mKnowTime.agencies( mId, response );
    }


    @Override
    public JSONObject toJson() {

        try {
            final JSONObject obj = new JSONObject();
            obj.put( "id", mId );
            obj.put( "name", mName );
            obj.put( "url", mUrl );
            obj.put( "etag", mEtag );
            obj.put( "created_at", mCreatedAt );
            return obj;
        } catch( final JSONException e ) {
            throw new RuntimeException( e );
        }
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "DataSetSummary{" );
        sb.append( "Id=" ).append( mId );
        sb.append( ", Name='" ).append( mName ).append( '\'' );
        sb.append( ", Url='" ).append( mUrl ).append( '\'' );
        sb.append( ", Etag='" ).append( mEtag ).append( '\'' );
        sb.append( ", CreatedAt='" ).append( mCreatedAt ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }


    public int getId() {
        return mId;
    }


    public String getName() {
        return mName;
    }


    public String getUrl() {
        return mUrl;
    }


    public String getEtag() {
        return mEtag;
    }


    public String getCreatedAt() {
        return mCreatedAt;
    }
}
