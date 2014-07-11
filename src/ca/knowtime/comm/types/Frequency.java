package ca.knowtime.comm.types;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.ids.TripId;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Frequency
        extends TripId
{
    private final String mStartTime;
    private final String mEndTime;
    private final int mHeadwaySeconds;
    private final Optional<Integer> mExactTimes;


    public Frequency( final KnowTimeAccess knowTime, final String id, final String startTime,
                      final String endTime, final int headwaySeconds,
                      final Optional<Integer> exactTimes ) {
        super( knowTime, id );
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
