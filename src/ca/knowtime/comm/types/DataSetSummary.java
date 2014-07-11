package ca.knowtime.comm.types;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.ids.DataSetId;
import com.google.common.base.Preconditions;

public class DataSetSummary
        extends DataSetId
{
    private final String mName;
    private final String mUrl;
    private final String mEtag;
    private final String mCreatedAt;


    public DataSetSummary( final KnowTimeAccess knowTime, final String id, final String name,
                           final String url, final String etag, final String createdAt ) {
        super( knowTime, id );
        mName = Preconditions.checkNotNull( name );
        mUrl = Preconditions.checkNotNull( url );
        mEtag = Preconditions.checkNotNull( etag );
        mCreatedAt = Preconditions.checkNotNull( createdAt );
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
