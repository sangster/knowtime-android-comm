package ca.knowtime.comm.models.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.models.gtfs.ids.TripId;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Frequency
        extends TripId
{
    private final String mStartTime;
    private final String mEndTime;
    private final int mHeadwaySeconds;
    private final Optional<Integer> mExactTimes;


    public Frequency( final GtfsAccess access,
                      final String id,
                      final String startTime,
                      final String endTime,
                      final int headwaySeconds,
                      final Optional<Integer> exactTimes ) {
        super( access, id );
        mStartTime = Preconditions.checkNotNull( startTime );
        mEndTime = Preconditions.checkNotNull( endTime );
        mHeadwaySeconds = Preconditions.checkNotNull( headwaySeconds );
        mExactTimes = Preconditions.checkNotNull( exactTimes );
    }


    public String getStartTime() {
        return mStartTime;
    }


    public String getEndTime() {
        return mEndTime;
    }


    public int getHeadwaySeconds() {
        return mHeadwaySeconds;
    }


    public Optional<Integer> getExactTimes() {
        return mExactTimes;
    }
}
