package ca.knowtime.comm.models.gtfs;

import ca.knowtime.comm.GtfsAccess;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Transfer
        extends GtfsModel
{
    private final String mFromStopId;
    private final String mToStopId;
    private final int mTransferType;
    private final Optional<Integer> mMinimumTransferTime;


    public Transfer( final GtfsAccess access,
                     final String fromStopId,
                     final String toStopId,
                     final int transferType,
                     final Optional<Integer> minimumTransferTime ) {
        super( access );
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
