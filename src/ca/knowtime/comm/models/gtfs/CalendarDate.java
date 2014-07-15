package ca.knowtime.comm.models.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.models.gtfs.ids.CalendarId;

public class CalendarDate
        extends CalendarId
{
    private final String mDate;
    private final int mExceptionType;


    public CalendarDate( final GtfsAccess access,
                         final String id,
                         final String date,
                         final int exceptionType ) {
        super( access, id );
        mDate = date;
        mExceptionType = exceptionType;
    }


    public String getDate() {
        return mDate;
    }


    public int getExceptionType() {
        return mExceptionType;
    }
}
