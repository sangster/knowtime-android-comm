package ca.knowtime.comm.models;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.models.ids.DataSetId;
import com.google.common.base.Optional;

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


        private float getLatitude() {
            return mLatitude;
        }


        private float getLongitude() {
            return mLongitude;
        }
    }


    private final String mName;
    private final String mLastUpdated;
    private final Location mNorthWestCorner;
    private final Location mSouthEastCorner;
    private final Optional<String> mStartDate;
    private final Optional<String> mEndDate;


    public DataSetSummary( final KnowTimeAccess knowTime,
                           final String id,
                           final String name,
                           final String lastUpdated,
                           final Location northWestCorner,
                           final Location southEastCorner,
                           final Optional<String> startDate,
                           final Optional<String> endDate ) {
        super( knowTime, id );
        mName = name;
        mLastUpdated = lastUpdated;
        mNorthWestCorner = northWestCorner;
        mSouthEastCorner = southEastCorner;
        mStartDate = startDate;
        mEndDate = endDate;
    }


    public String getName() {
        return mName;
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
