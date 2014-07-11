package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.CalendarDate;
import org.json.JSONObject;

import java.util.List;

public class CalendarDateParser
        extends JsonParser<CalendarDate>
{
    public static class Factory
            implements ParserFactory<CalendarDate>
    {
        @Override
        public JsonParser<CalendarDate> parser( final KnowTimeAccess knowTime,
                                                final JSONObject res ) {
            return new CalendarDateParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<CalendarDate>>
    {
        @Override
        public JsonParser<List<CalendarDate>> parser( final KnowTimeAccess knowTime,
                                                      final JSONObject res ) {
            return new ListParser<>( "calendar_dates", new Factory(), knowTime, res );
        }
    }


    public CalendarDateParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "", knowTime, json );
    }


    @Override
    public CalendarDate get()
    throws ParseException {
        return new CalendarDate( mKnowTime,
                                 opt( "service_id" ).orNull(),
                                 opt( "date" ).orNull(),
                                 optInteger( "exception_type" ).orNull() );
    }
}
