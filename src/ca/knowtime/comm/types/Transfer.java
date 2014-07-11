package ca.knowtime.comm.types;

import ca.knowtime.comm.KnowTimeAccess;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Transfer
        extends KnowtimeModel
{
    private final String mFromStopId;
    private final String mToStopId;
    private final int mTransferType;
    private final Optional<Integer> mMinimumTransferTime;


    public Transfer( final KnowTimeAccess knowTime, final String fromStopId, final String toStopId,
                     final int transferType, final Optional<Integer> minimumTransferTime ) {
        super( knowTime );
        mFromStopId = Preconditions.checkNotNull( fromStopId );
        mToStopId = Preconditions.checkNotNull( toStopId );
        mTransferType = Preconditions.checkNotNull( transferType );
        mMinimumTransferTime = Preconditions.checkNotNull( minimumTransferTime );
    }


    public String getFromStopId() {
        return mFromStopId;
    }


    public String getToStopId() {
        return mToStopId;
    }


    public int getTransferType() {
        return mTransferType;
    }


    public Optional<Integer> getMinimumTransferTime() {
        return mMinimumTransferTime;
    }
}
