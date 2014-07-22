package ca.knowtime.comm.models.gtfs;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class FeedInfo
        extends GtfsModel
{
    private final String mFeedPublisherName;
    private final String mFeedPublisherUrl;
    private final String mFeedLang;
    private final Optional<String> mFeedStartDate;
    private final Optional<String> mFeedEndDate;
    private final Optional<String> mFeedVersion;


    public FeedInfo( final String feedPublisherName,
                     final String feedPublisherUrl,
                     final String feedLang,
                     final Optional<String> feedStartDate,
                     final Optional<String> feedEndDate,
                     final Optional<String> feedVersion ) {
        mFeedPublisherName = Preconditions.checkNotNull( feedPublisherName );
        mFeedPublisherUrl = Preconditions.checkNotNull( feedPublisherUrl );
        mFeedLang = Preconditions.checkNotNull( feedLang );
        mFeedStartDate = Preconditions.checkNotNull( feedStartDate );
        mFeedEndDate = Preconditions.checkNotNull( feedEndDate );
        mFeedVersion = Preconditions.checkNotNull( feedVersion );
    }


    public String getFeedPublisherName() {
        return mFeedPublisherName;
    }


    public String getFeedPublisherUrl() {
        return mFeedPublisherUrl;
    }


    public String getFeedLang() {
        return mFeedLang;
    }


    public Optional<String> getFeedStartDate() {
        return mFeedStartDate;
    }


    public Optional<String> getFeedEndDate() {
        return mFeedEndDate;
    }


    public Optional<String> getFeedVersion() {
        return mFeedVersion;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper( this )
                      .add( "FeedPublisherName", mFeedPublisherName )
                      .add( "FeedPublisherUrl", mFeedPublisherUrl )
                      .add( "FeedLang", mFeedLang )
                      .add( "FeedStartDate", mFeedStartDate )
                      .add( "FeedEndDate", mFeedEndDate )
                      .add( "FeedVersion", mFeedVersion )
                      .toString();
    }
}
