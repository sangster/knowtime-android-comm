package ca.knowtime.comm.parsers.gtfs;


import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.Calendar;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import com.google.common.base.Optional;
import org.json.JSONObject;

import java.util.List;

public class CalendarParser
        extends JsonParser<Calendar>
{
    public static class Factory
            implements ParserFactory<Calendar>
    {
        @Override
        public JsonParser<Calendar> parser( final JSONObject res ) {
            return new CalendarParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Calendar>>
    {
        @Override
        public JsonParser<List<Calendar>> parser( final JSONObject res ) {
            return new ListParser<>( "calendars", new Factory(), res );
        }
    }


    public CalendarParser( final JSONObject json ) {
        super( "", json );
    }


    @Override
    public Calendar get()
    throws ParseException {
        return new Calendar( opt( "service_id" ).get(),
                             optBoolean( "monday" ).get(),
                             optBoolean( "tuesday" ).get(),
                             optBoolean( "wednesday" ).get(),
                             optBoolean( "thursday" ).get(),
                             optBoolean( "friday" ).get(),
                             optBoolean( "saturday" ).get(),
                             optBoolean( "sunday" ).get(),
                             opt( "start_date" ).get(),
                             opt( "end_date" ).get() );
    }


    private Optional<Boolean> optBoolean( final String key ) {
        if( mJson.has( key ) ) {
            return Optional.of( mJson.optBoolean( key ) );
        }
        return Optional.absent();
    }
}
