package ca.knowtime.comm.parsers.gtfs;

import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.models.gtfs.Shape;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import org.json.JSONObject;

import java.util.List;

public class ShapeParser
        extends JsonParser<Shape>
{
    public static class Factory
            implements ParserFactory<Shape>
    {
        @Override
        public JsonParser<Shape> parser( final JSONObject res ) {
            return new ShapeParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Shape>>
    {
        @Override
        public JsonParser<List<Shape>> parser( final JSONObject res ) {
            return new ListParser<>( "shapes", new Factory(), res );
        }
    }


    protected ShapeParser( final JSONObject json ) {
        super( "shape", json );
    }


    @Override
    public Shape get()
    throws ParseException {
        return new Shape( unaliasIntern( "id" ).get(),
                          unaliasFloat( "pt_lat" ).get(),
                          unaliasFloat( "pt_lon" ).get(),
                          unaliasInteger( "pt_sequence" ).get(),
                          unaliasFloat( "dist_traveled" ) );
    }
}
