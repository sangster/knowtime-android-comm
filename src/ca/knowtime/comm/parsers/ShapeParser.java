package ca.knowtime.comm.parsers;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.exceptions.ParseException;
import ca.knowtime.comm.types.Shape;
import org.json.JSONObject;

import java.util.List;

public class ShapeParser
        extends JsonParser<Shape>
{
    public static class Factory
            implements ParserFactory<Shape>
    {
        @Override
        public JsonParser<Shape> parser( final KnowTimeAccess knowTime, final JSONObject res ) {
            return new ShapeParser( knowTime, res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Shape>>
    {
        @Override
        public JsonParser<List<Shape>> parser( final KnowTimeAccess knowTime,
                                               final JSONObject res ) {
            return new ListParser<>( "shapes", new Factory(), knowTime, res );
        }
    }


    protected ShapeParser( final KnowTimeAccess knowTime, final JSONObject json ) {
        super( "shape", knowTime, json );
    }


    @Override
    public Shape get()
    throws ParseException {
        return new Shape( mKnowTime,
                          unaliasIntern( "id" ).orNull(),
                          unaliasFloat( "pt_lat" ).orNull(),
                          unaliasFloat( "pt_lon" ).orNull(),
                          unaliasInteger( "pt_sequence" ).orNull(),
                          unaliasFloat( "dist_traveled" ) );
    }
}
