package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.CalendarDate;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class CalendarDateParser
        extends JsonParser<CalendarDate>
{
    public static class Factory
            implements ParserFactory<CalendarDate>
    {
        @Override
        public JsonParser<CalendarDate> parser( final JSONObject res ) {
            return new CalendarDateParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<CalendarDate>>
    {
        @Override
        public JsonParser<List<CalendarDate>> parser( final JSONObject res ) {
            return new ListParser<>( "calendar_dates", new Factory(), res );
        }
    }


    public CalendarDateParser( final JSONObject json ) {
        super( "", json );
    }


    @Override
    public CalendarDate get()
    throws ParseException {
        return new CalendarDate( opt( "service_id" ).get(),
                                 opt( "date" ).get(),
                                 optInteger( "exception_type" ).get() );
    }
}
