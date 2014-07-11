package ca.knowtime.comm.types.ids;


import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.Response;
import ca.knowtime.comm.types.Agency;
import ca.knowtime.comm.types.Stop;

import java.util.List;

public class DataSetId
        extends BasicModelId
{
    public DataSetId( final KnowTimeAccess knowTime, final String id ) {
        super( knowTime, id );
    }


    public void agencies( final Response<List<Agency>> response ) {
        mKnowTime.agencies( mId, response );
    }


    public void stops( final Response<List<Stop>> response ) {
        mKnowTime.stops( mId, response );
    }
}
