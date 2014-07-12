package ca.knowtime.comm.models.gtfs;

import ca.knowtime.comm.GtfsAccess;
import ca.knowtime.comm.models.gtfs.ids.ShapeId;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class Shape
        extends ShapeId
{
    private final float mPointLatitude;
    private final float mPointLongitude;
    private final int mPointSequence;
    private final Optional<Float> mDistanceTraveled;


    public Shape( final GtfsAccess access,
                  final String id,
                  final float pointLatitude,
                  final float pointLongitude,
                  final int pointSequence,
                  final Optional<Float> distanceTraveled ) {
        super( access, id );
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
