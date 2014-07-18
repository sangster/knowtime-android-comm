package ca.knowtime.comm.models.gtfs;


import ca.knowtime.comm.models.gtfs.enums.RouteType;
import ca.knowtime.comm.models.gtfs.ids.RouteId;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Route
        extends RouteId
{
    private final String mShortName;
    private final String mLongName;
    private final RouteType mType;
    private final Optional<String> mAgencyId;
    private final Optional<String> mDescription;
    private final Optional<String> mUrl;
    private final Optional<String> mColor;
    private final Optional<String> mTextColor;


    public Route( final String id,
                  final String shortName,
                  final String longName,
                  final RouteType type,
                  final Optional<String> agencyId,
                  final Optional<String> description,
                  final Optional<String> url,
                  final Optional<String> color,
                  final Optional<String> textColor ) {
        super( id );
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


    public RouteType getType() {
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


    @Override
    public String toString() {
        return Objects.toStringHelper( this )
                      .add( "ShortName", mShortName )
                      .add( "LongName", mLongName )
                      .add( "Type", mType )
                      .add( "AgencyId", mAgencyId )
                      .add( "Description", mDescription )
                      .add( "Url", mUrl )
                      .add( "Color", mColor )
                      .add( "TextColor", mTextColor )
                      .toString();
    }
}
