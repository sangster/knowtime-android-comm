package ca.knowtime.comm.models.gtfs;

import ca.knowtime.comm.GtfsAccess;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class FeedInfo
        extends GtfsModel
{
    private final String mPublisherName;
    private final String mPublisherUrl;
    private final String mLanguage;
    private final Optional<String> mStartDate;
    private final Optional<String> mEndDate;
    private final Optional<String> mVersion;


    public FeedInfo( final GtfsAccess access,
                     final String publisherName,
                     final String publisherUrl,
                     final String language,
                     final Optional<String> startDate,
                     final Optional<String> endDate,
                     final Optional<String> version ) {
        super( access );
        mPublisherName = Preconditions.checkNotNull( publisherName );
        mPublisherUrl = Preconditions.checkNotNull( publisherUrl );
        mLanguage = Preconditions.checkNotNull( language );
        mStartDate = Preconditions.checkNotNull( startDate );
        mEndDate = Preconditions.checkNotNull( endDate );
        mVersion = Preconditions.checkNotNull( version );
    }


    public String getPublisherName() {
        return mPublisherName;
    }


    public String getPublisherUrl() {
        return mPublisherUrl;
    }


    public String getLanguage() {
        return mLanguage;
    }


    public Optional<String> getStartDate() {
        return mStartDate;
    }


    public Optional<String> getEndDate() {
        return mEndDate;
    }


    public Optional<String> getVersion() {
        return mVersion;
    }
}
