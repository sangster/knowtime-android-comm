package ca.knowtime.comm.parsers.gtfs;


import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.Calendar;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import com.google.common.base.Optional;
import org.json.JSONObject;

import java.util.List;

public class CalendarParser
        extends JsonParser<Calendar, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<Calendar, GtfsAccess>
    {
        public Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<Calendar, GtfsAccess> parser( final JSONObject res ) {
            return new CalendarParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<Calendar>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<Calendar>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "calendars", new Factory( mAccess ), mAccess, res );
        }
    }


    public CalendarParser( final GtfsAccess access, final JSONObject json ) {
        super( "", access, json );
    }


    @Override
    public Calendar get()
    throws ParseException {
        return new Calendar( mAccess,
                             opt( "service_id" ).get(),
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
