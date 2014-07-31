package ca.knowtime.comm.models.gtfs;

import ca.knowtime.comm.models.gtfs.ids.FareId;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class FareAttribute
        extends FareId
{
    private final String mPrice;
    private final String mCurrencyType;
    private final int mPaymentMethod;
    private final int mTransfers;
    private final Optional<Integer> mTransferDuration; // in seconds


    public FareAttribute( final String fareId,
                          final String price,
                          final String currencyType,
                          final int paymentMethod,
                          final int transfers,
                          final Optional<Integer> transferDuration ) {
        super( fareId );
        mPrice = Preconditions.checkNotNull( price );
        mCurrencyType = Preconditions.checkNotNull( currencyType );
        mPaymentMethod = Preconditions.checkNotNull( paymentMethod );
        mTransfers = Preconditions.checkNotNull( transfers );
        mTransferDuration = Preconditions.checkNotNull( transferDuration );
    }


    public String getPrice() {
        return mPrice;
    }


    public String getCurrencyType() {
        return mCurrencyType;
    }


    public int getPaymentMethod() {
        return mPaymentMethod;
    }


    public int getTransfers() {
        return mTransfers;
    }


    public Optional<Integer> getTransferDuration() {
        return mTransferDuration;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper( this )
                      .add( "FareId", mId )
                      .add( "Price", mPrice )
                      .add( "CurrencyType", mCurrencyType )
                      .add( "PaymentMethod", mPaymentMethod )
                      .add( "Transfers", mTransfers )
                      .add( "TransferDuration", mTransferDuration )
                      .toString();
    }
}
