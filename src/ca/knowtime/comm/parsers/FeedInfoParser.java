package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.FeedInfo;
import org.json.JSONObject;

import java.util.List;

public class FeedInfoParser
        extends JsonParser<FeedInfo>
{
    public static class Factory
            implements ParserFactory<FeedInfo>
    {
        @Override
        public JsonParser<FeedInfo> parser( final KnowTimeAccess knowTime, final JSONObject res ) {
            return new FeedInfoParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<FeedInfo>>
    {
        @Override
        public JsonParser<List<FeedInfo>> parser( final KnowTimeAccess knowTime,
                                                  final JSONObject res ) {
            return new ListParser<>( "feed_infos", new Factory(), knowTime, res );
        }
    }


    public FeedInfoParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "feed", knowTime, json );
    }


    @Override
    public FeedInfo get()
    throws ParseException {
        return new FeedInfo( mKnowTime,
                             unalias( "publisher_name" ).orNull(),
                             unalias( "publisher_url" ).orNull(),
                             unalias( "lang" ).orNull(),
                             unalias( "start_date" ),
                             unalias( "end_date" ),
                             unalias( "version" ) );
    }
}
