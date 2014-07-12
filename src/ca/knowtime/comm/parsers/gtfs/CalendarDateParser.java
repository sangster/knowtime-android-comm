package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.CalendarDate;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class CalendarDateParser
        extends JsonParser<CalendarDate, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<CalendarDate, GtfsAccess>
    {
        public Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<CalendarDate, GtfsAccess> parser( final JSONObject res ) {
            return new CalendarDateParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<CalendarDate>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<CalendarDate>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "calendar_dates", new Factory( mAccess ), mAccess, res );
        }
    }


    public CalendarDateParser( final GtfsAccess access, final JSONObject json ) {
        super( "", access, json );
    }


    @Override
    public CalendarDate get()
    throws ParseException {
        return new CalendarDate( mAccess,
                                 opt( "service_id" ).orNull(),
                                 opt( "date" ).orNull(),
                                 optInteger( "exception_type" ).orNull() );
    }
}
