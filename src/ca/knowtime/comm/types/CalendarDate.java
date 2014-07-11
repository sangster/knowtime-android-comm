package ca.knowtime.comm.types;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.ids.CalendarId;

public class CalendarDate
        extends CalendarId
{
    private final String mDate;
    private final int mExceptionType;


    public CalendarDate( final KnowTimeAccess knowtimeAccess, final String id, final String date,
                         final int exceptionType ) {
        super( knowtimeAccess, id );
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
