package ca.knowtime.comm.models.ids;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.models.BasicKnowTimeModelId;

public class DataSetId
        extends BasicKnowTimeModelId
{
    public DataSetId( final KnowTimeAccess access, final String id ) {
        super( access, id );
    }
}
