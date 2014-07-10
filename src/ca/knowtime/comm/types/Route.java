package ca.knowtime.comm.types;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.ids.RouteId;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Route
        extends RouteId
{
    private final String mShortName;
    private final String mLongName;
    private final int mType;
    private final Optional<String> mAgencyId;
    private final Optional<String> mDescription;
    private final Optional<String> mUrl;
    private final Optional<String> mColor;
    private final Optional<String> mTextColor;


    public Route( final KnowTimeAccess knowTime, final String id, final String shortName,
                  final String longName, final int type, final Optional<String> agencyId,
                  final Optional<String> description, final Optional<String> url,
                  final Optional<String> color, final Optional<String> textColor ) {
        super( knowTime, id );
        mShortName = Preconditions.checkNotNull( shortName );
        mLongName = Preconditions.checkNotNull( longName );
        mType = Preconditions.checkNotNull( type );
        mAgencyId = Preconditions.checkNotNull( agencyId );
        mDescription = Preconditions.checkNotNull( description );
        mUrl = Preconditions.checkNotNull( url );
        mColor = Preconditions.checkNotNull( color );
        mTextColor = Preconditions.checkNotNull( textColor );
    }


    public String getShortName() {
        return mShortName;
    }


    public String getLongName() {
        return mLongName;
    }


    public int getType() {
        return mType;
    }


    public Optional<String> getAgencyId() {
        return mAgencyId;
    }


    public Optional<String> getDescription() {
        return mDescription;
    }


    public Optional<String> getUrl() {
        return mUrl;
    }


    public Optional<String> getColor() {
        return mColor;
    }


    public Optional<String> getTextColor() {
        return mTextColor;
    }
}
