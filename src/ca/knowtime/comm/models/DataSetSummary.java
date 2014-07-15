package ca.knowtime.comm.models;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.models.ids.DataSetId;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class DataSetSummary
        extends DataSetId
{
    public static class Location
    {
        private final float mLatitude;
        private final float mLongitude;


        public Location( final float latitude, final float longitude ) {
            mLatitude = latitude;
            mLongitude = longitude;
        }


        public float getLatitude() {
            return mLatitude;
        }


        public float getLongitude() {
            return mLongitude;
        }
    }


    private final String mName;
    private final String mTitle;
    private final String mLastUpdated;
    private final Location mNorthWestCorner;
    private final Location mSouthEastCorner;
    private final Optional<String> mStartDate;
    private final Optional<String> mEndDate;


    public DataSetSummary( final KnowTimeAccess knowTime,
                           final String id,
                           final String name,
                           final String title,
                           final String lastUpdated,
                           final Location northWestCorner,
                           final Location southEastCorner,
                           final Optional<String> startDate,
                           final Optional<String> endDate ) {
        super( knowTime, id );
        mName = Preconditions.checkNotNull( name );
        mTitle = Preconditions.checkNotNull( title );
        mLastUpdated = Preconditions.checkNotNull( lastUpdated );
        mNorthWestCorner = Preconditions.checkNotNull( northWestCorner );
        mSouthEastCorner = Preconditions.checkNotNull( southEastCorner );
        mStartDate = Preconditions.checkNotNull( startDate );
        mEndDate = Preconditions.checkNotNull( endDate );
    }


    public String getName() {
        return mName;
    }


    public String getTitle() {
        return mTitle;
    }


    public String getLastUpdated() {
        return mLastUpdated;
    }


    public Location getNorthWestCorner() {
        return mNorthWestCorner;
    }


    public Location getSouthEastCorner() {
        return mSouthEastCorner;
    }


    public Optional<String> getStartDate() {
        return mStartDate;
    }


    public Optional<String> getEndDate() {
        return mEndDate;
    }
}
