package ca.knowtime.comm.models.gtfs;

import ca.knowtime.comm.models.gtfs.ids.ServiceId;
import com.google.common.base.Objects;

public class CalendarDate
        extends ServiceId
{
    private final String mDate;
    private final int mExceptionType;


    public CalendarDate( final String serviceId,
                         final String date,
                         final int exceptionType ) {
        super( serviceId );
        mDate = date;
        mExceptionType = exceptionType;
    }


    public String getDate() {
        return mDate;
    }


    public int getExceptionType() {
        return mExceptionType;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper( this )
                      .add( "ServiceId", mId )
                      .add( "Date", mDate )
                      .add( "ExceptionType", mExceptionType )
                      .toString();
    }
}
