package ca.knowtime.comm.types;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.ids.CalendarId;
import com.google.common.base.Preconditions;

public class Calendar
        extends CalendarId
{
    private final boolean mMonday;
    private final boolean mTuesday;
    private final boolean mWednesday;
    private final boolean mThursday;
    private final boolean mFriday;
    private final boolean mSaturday;
    private final boolean mSunday;
    private final String mStartDate;
    private final String mEndDate;


    public Calendar( final KnowTimeAccess knowTime, final String id, final boolean monday,
                     final boolean tuesday, final boolean wednesday, final boolean thursday,
                     final boolean friday, final boolean saturday, final boolean sunday,
                     final String startDate, final String endDate ) {
        super( knowTime, id );
        mMonday = Preconditions.checkNotNull( monday );
        mTuesday = Preconditions.checkNotNull( tuesday );
        mWednesday = Preconditions.checkNotNull( wednesday );
        mThursday = Preconditions.checkNotNull( thursday );
        mFriday = Preconditions.checkNotNull( friday );
        mSaturday = Preconditions.checkNotNull( saturday );
        mSunday = Preconditions.checkNotNull( sunday );
        mStartDate = Preconditions.checkNotNull( startDate );
        mEndDate = Preconditions.checkNotNull( endDate );
    }


    public boolean isMonday() {
        return mMonday;
    }


    public boolean isTuesday() {
        return mTuesday;
    }


    public boolean isWednesday() {
        return mWednesday;
    }


    public boolean isThursday() {
        return mThursday;
    }


    public boolean isFriday() {
        return mFriday;
    }


    public boolean isSaturday() {
        return mSaturday;
    }


    public boolean isSunday() {
        return mSunday;
    }


    public String getStartDate() {
        return mStartDate;
    }


    public String getEndDate() {
        return mEndDate;
    }
}
