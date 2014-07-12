package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.Shape;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class ShapeParser
        extends JsonParser<Shape, GtfsAccess>
{
    public static class Factory
            extends ParserFactory<Shape, GtfsAccess>
    {
        public Factory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<Shape, GtfsAccess> parser( final JSONObject res ) {
            return new ShapeParser( mAccess, res );
        }
    }

    public static class ListFactory
            extends ParserFactory<List<Shape>, GtfsAccess>
    {
        public ListFactory( final GtfsAccess access ) {
            super( access );
        }


        @Override
        public JsonParser<List<Shape>, GtfsAccess> parser( final JSONObject res ) {
            return new ListParser<>( "shapes", new Factory( mAccess ), mAccess, res );
        }
    }


    protected ShapeParser( final GtfsAccess access, final JSONObject json ) {
        super( "shape", access, json );
    }


    @Override
    public Shape get()
    throws ParseException {
        return new Shape( mAccess,
                          unaliasIntern( "id" ).orNull(),
                          unaliasFloat( "pt_lat" ).orNull(),
                          unaliasFloat( "pt_lon" ).orNull(),
                          unaliasInteger( "pt_sequence" ).orNull(),
                          unaliasFloat( "dist_traveled" ) );
    }
}
