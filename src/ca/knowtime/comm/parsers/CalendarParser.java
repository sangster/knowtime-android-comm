package ca.knowtime.comm.parsers;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.Calendar;
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
        public JsonParser<Calendar> parser( final KnowTimeAccess knowTime, final JSONObject res ) {
            return new CalendarParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Calendar>>
    {
        @Override
        public JsonParser<List<Calendar>> parser( final KnowTimeAccess knowTime,
                                                  final JSONObject res ) {
            return new ListParser<>( "calendars", new Factory(), knowTime, res );
        }
    }


    public CalendarParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "", knowTime, json );
    }


    @Override
    public Calendar get()
    throws ParseException {
        return new Calendar( mKnowTime,
                             opt( "service_id" ).orNull(),
                             optBoolean( "monday" ).orNull(),
                             optBoolean( "tuesday" ).orNull(),
                             optBoolean( "wednesday" ).orNull(),
                             optBoolean( "thursday" ).orNull(),
                             optBoolean( "friday" ).orNull(),
                             optBoolean( "saturday" ).orNull(),
                             optBoolean( "sunday" ).orNull(),
                             opt( "start_date" ).orNull(),
                             opt( "end_date" ).orNull() );
    }


    private Optional<Boolean> optBoolean( final String key ) {
        if( mJson.has( key ) ) {
            return Optional.of( mJson.optBoolean( key ) );
        }
        return Optional.absent();
    }
}
