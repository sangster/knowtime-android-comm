package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.FeedInfo;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class FeedInfoParser
        extends JsonParser<FeedInfo, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<FeedInfo, GtfsAccess>
    {
        protected Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<FeedInfo, GtfsAccess> parser( final JSONObject res ) {
            return new FeedInfoParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<FeedInfo>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<FeedInfo>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "feed_infos", new Factory( mAccess ), mAccess, res );
        }
    }


    public FeedInfoParser( final GtfsAccess access, final JSONObject json ) {
        super( "feed", access, json );
    }


    @Override
    public FeedInfo get()
    throws ParseException {
        return new FeedInfo( mAccess,
                             unalias( "publisher_name" ).get(),
                             unalias( "publisher_url" ).get(),
                             unalias( "lang" ).get(),
                             unalias( "start_date" ),
                             unalias( "end_date" ),
                             unalias( "version" ) );
    }
}
