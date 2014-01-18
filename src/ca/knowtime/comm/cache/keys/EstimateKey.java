package ca.knowtime.comm.cache.keys;

import ca.knowtime.comm.cache.CacheCategory;

public class EstimateKey
        implements CacheKey
{
    private final String mShortName;


    public EstimateKey( final String shortName ) {
        mShortName = shortName;
    }


    @Override
    public CacheCategory getCategory() {
        return CacheCategory.estimates;
    }


    @Override
    public boolean equals( final Object o ) {
        if( this == o ) {
            return true;
        }
        if( !(o instanceof EstimateKey) ) {
            return false;
        }

        final EstimateKey that = (EstimateKey) o;
        return mShortName.equals( that.mShortName );
    }


    @Override
    public int hashCode() {
        return mShortName.hashCode();
    }
}
