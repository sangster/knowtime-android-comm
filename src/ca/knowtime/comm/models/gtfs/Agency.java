package ca.knowtime.comm.models.gtfs;


import ca.knowtime.comm.GtfsAccess;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Agency
        extends GtfsModel
{
    private final String mName;
    private final String mUrl;
    private final String mTimezone;
    private final Optional<String> mId;
    private final Optional<String> mLang;
    private final Optional<String> mPhone;
    private final Optional<String> mFareUrl;


    public Agency( final GtfsAccess access,
                   final String name,
                   final String url,
                   final String timezone,
                   final Optional<String> id,
                   final Optional<String> lang,
                   final Optional<String> phone,
                   final Optional<String> fareUrl ) {
        super( access );
        mName = Preconditions.checkNotNull( name );
        mUrl = Preconditions.checkNotNull( url );
        mTimezone = Preconditions.checkNotNull( timezone );
        mId = Preconditions.checkNotNull( id );
        mLang = Preconditions.checkNotNull( lang );
        mPhone = Preconditions.checkNotNull( phone );
        mFareUrl = Preconditions.checkNotNull( fareUrl );
    }


    public String getName() {
        return mName;
    }


    public String getUrl() {
        return mUrl;
    }


    public String getTimezone() {
        return mTimezone;
    }


    public Optional<String> getId() {
        return mId;
    }


    public Optional<String> getLang() {
        return mLang;
    }


    public Optional<String> getPhone() {
        return mPhone;
    }


    public Optional<String> getFareUrl() {
        return mFareUrl;
    }
}
