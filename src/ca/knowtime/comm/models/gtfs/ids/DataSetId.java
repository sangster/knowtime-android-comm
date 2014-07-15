package ca.knowtime.comm.models.gtfs.ids;


import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.Response;
import ca.knowtime.comm.models.gtfs.Agency;
import ca.knowtime.comm.models.gtfs.Stop;

import java.util.List;

public class DataSetId
        extends BasicGtfsModelId
{
    public DataSetId( final GtfsAccess knowTime, final String id ) {
        super( knowTime, id );
    }


    public void agencies( final Object tag, final Response<List<Agency>> response ) {
        mAccess.agencies( tag, mId, response );
    }


    public void stops( final Object tag, final Response<List<Stop>> response ) {
        mAccess.stops( tag, mId, response );
    }
}
