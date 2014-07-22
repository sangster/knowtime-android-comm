package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.FeedInfo;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class FeedInfoParser
        extends JsonParser<FeedInfo>
{
    public static class Factory
            implements ParserFactory<FeedInfo>
    {
        @Override
        public JsonParser<FeedInfo> parser( final JSONObject res ) {
            return new FeedInfoParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<FeedInfo>>
    {
        @Override
        public JsonParser<List<FeedInfo>> parser( final JSONObject res ) {
            return new ListParser<>( "feed_infos", new Factory(), res );
        }
    }


    public FeedInfoParser( final JSONObject json ) {
        super( json );
    }


    @Override
    public FeedInfo get()
    throws ParseException {
        return new FeedInfo( opt( "feed_publisher_name" ).get(),
                             opt( "feed_publisher_url" ).get(),
                             opt( "feed_lang" ).get(),
                             opt( "feed_start_date" ),
                             opt( "feed_end_date" ),
                             opt( "feed_version" ) );
    }
}
