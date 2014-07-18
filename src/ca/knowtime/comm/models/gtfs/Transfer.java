package ca.knowtime.comm.models.gtfs;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Transfer
        extends GtfsModel
{
    private final String mFromStopId;
    private final String mToStopId;
    private final int mTransferType;
    private final Optional<Integer> mMinimumTransferTime;


    public Transfer( final String fromStopId,
                     final String toStopId,
                     final int transferType,
                     final Optional<Integer> minimumTransferTime ) {
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


    @Override
    public boolean equals( final Object o ) {
        if( this == o ) {
            return true;
        }
        if( !(o instanceof Transfer) ) {
            return false;
        }

        final Transfer transfer = (Transfer) o;
        return mTransferType == transfer.mTransferType && mFromStopId.equals(
                transfer.mFromStopId ) && mToStopId.equals( transfer.mToStopId );
    }


    @Override
    public int hashCode() {
        int result = mFromStopId.hashCode();
        result = 31 * result + mToStopId.hashCode();
        result = 31 * result + mTransferType;
        return result;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper( this )
                      .add( "FromStopId", mFromStopId )
                      .add( "ToStopId", mToStopId )
                      .add( "TransferType", mTransferType )
                      .add( "MinimumTransferTime", mMinimumTransferTime )
                      .toString();
    }
}
