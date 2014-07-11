package ca.knowtime.comm.types;


import ca.knowtime.comm.KnowTimeAccess;
import com.google.common.base.Preconditions;

public class KnowtimeModel
{
    protected final KnowTimeAccess mKnowTime;


    public KnowtimeModel( final KnowTimeAccess knowTime ) {
        mKnowTime = Preconditions.checkNotNull( knowTime );
    }
}
