package ca.knowtime.comm.models.gtfs;

import ca.knowtime.comm.models.gtfs.ids.CalendarId;

public class CalendarDate
        extends CalendarId
{
    private final String mDate;
    private final int mExceptionType;


    public CalendarDate( final String id,
                         final String date,
                         final int exceptionType ) {
        super( id );
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
