package ca.knowtime.comm.types;

import ca.knowtime.comm.KnowTimeAccess;
import ca.knowtime.comm.types.ids.ShapeId;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Shape
        extends ShapeId
{
    private final float mPointLatitude;
    private final float mPointLongitude;
    private final int mPointSequence;
    private final Optional<Float> mDistanceTraveled;


    public Shape( final KnowTimeAccess knowTime, final String id, final float pointLatitude,
                  final float pointLongitude, final int pointSequence,
                  final Optional<Float> distanceTraveled ) {
        super( knowTime, id );
        mPointLatitude = Preconditions.checkNotNull( pointLatitude );
        mPointLongitude = Preconditions.checkNotNull( pointLongitude );
        mPointSequence = Preconditions.checkNotNull( pointSequence );
        mDistanceTraveled = Preconditions.checkNotNull( distanceTraveled );
    }


    public float getPointLatitude() {
        return mPointLatitude;
    }


    public float getPointLongitude() {
        return mPointLongitude;
    }


    public int getPointSequence() {
        return mPointSequence;
    }


    public Optional<Float> getDistanceTraveled() {
        return mDistanceTraveled;
    }
}
