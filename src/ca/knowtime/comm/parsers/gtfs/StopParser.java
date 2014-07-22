package ca.knowtime.comm.parsers.gtfs;


import ca.knowtime.comm.models.gtfs.Stop;
import ca.knowtime.comm.models.gtfs.enums.LocationType;
import ca.knowtime.comm.models.gtfs.enums.WheelchairBoarding;
import ca.knowtime.comm.parsers.JsonParser;
import ca.knowtime.comm.parsers.ListParser;
import ca.knowtime.comm.parsers.ParserFactory;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.json.JSONObject;

import java.util.List;

public class StopParser
        extends JsonParser<Stop>
{
    public static class Factory
            implements ParserFactory<Stop>
    {
        @Override
        public JsonParser<Stop> parser( final JSONObject res ) {
            return new StopParser( res );
        }
    }

    public static class ListFactory
            implements ParserFactory<List<Stop>>
    {
        @Override
        public JsonParser<List<Stop>> parser( final JSONObject res ) {
            return new ListParser<>( "stops", new Factory(), res );
        }
    }


    public StopParser( final JSONObject json ) {
        super( json );
    }


    public Stop get() {
        return new Stop( opt( "stop_id" ).get(),
                         opt( "stop_name" ).get(),
                         optFloat( "stop_lat" ).get(),
                         optFloat( "stop_lon" ).get(),
                         opt( "stop_code" ),
                         opt( "stop_desc" ),
                         opt( "zone_id" ),
                         opt( "stop_url" ),
                         optLocationType(),
                         optInteger( "parent_station" ),
                         opt( "stop_timezone" ),
                         optWheelchairBoarding() );
    }


    private Optional<LocationType> optLocationType() {
        if( !mJson.has( "location_type" ) ) {
            return Optional.absent();
        }

        final String type = mJson.optString( "location_type" );

        switch( type ) {
            case "":
            case "0":
                return Optional.of( LocationType.blank );
            case "1":
                return Optional.of( LocationType.station );
            default:
                throw new IllegalArgumentException( "Unknown location type: " + type );
        }
    }


    private Optional<WheelchairBoarding> optWheelchairBoarding() {
        if( !mJson.has( "wheelchair_boarding" ) ) {
            return Optional.absent();
        }

        final String type = mJson.optString( "wheelchair_boarding" );

        if( Strings.isNullOrEmpty( mJson.optString( "parent_station" ) ) ) {
            switch( type ) {
                case "":
                case "0":
                    return Optional.of( WheelchairBoarding.inherit );
                case "1":
                    return Optional.of( WheelchairBoarding.some_path );
                case "2":
                    return Optional.of( WheelchairBoarding.no_path );
            }
        } else {
            switch( type ) {
                case "":
                case "0":
                    return Optional.of( WheelchairBoarding.unknown );
                case "1":
                    return Optional.of( WheelchairBoarding.yes );
                case "2":
                    return Optional.of( WheelchairBoarding.no );
            }
        }

        throw new IllegalArgumentException( "Unknown wheelchair boarding: " + type );
    }
}
