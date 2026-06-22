package io.github.mapvina.reactnative.events;

import android.graphics.PointF;
import androidx.annotation.NonNull;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

import io.github.mapvina.android.geometry.LatLng;
import io.github.mapvina.reactnative.components.annotations.pointannotation.MLRNPointAnnotation;
import io.github.mapvina.reactnative.events.constants.EventKeys;
import io.github.mapvina.reactnative.events.constants.EventTypes;
import io.github.mapvina.reactnative.utils.GeoJSONUtils;

public class PointAnnotationClickEvent extends MapClickEvent {
    private MLRNPointAnnotation mView;
    private LatLng mTouchedLatLng;
    private PointF mScreenPoint;

    public PointAnnotationClickEvent(MLRNPointAnnotation view, @NonNull LatLng latLng, @NonNull PointF screenPoint, String eventType) {
        super(view, latLng, screenPoint, eventType);
        mView = view;
        mTouchedLatLng = latLng;
        mScreenPoint = screenPoint;
    }

    @Override
    public String getKey() {
        return getType().equals(EventTypes.ANNOTATION_SELECTED) ? EventKeys.POINT_ANNOTATION_SELECTED : EventKeys.POINT_ANNOTATION_DESELECTED;
    }

    @Override
    public WritableMap getPayload() {
        WritableMap properties = new WritableNativeMap();
        properties.putString("id", mView.getMapVinaId());
        properties.putDouble("screenPointX", mScreenPoint.x);
        properties.putDouble("screenPointY", mScreenPoint.y);
        return GeoJSONUtils.toPointFeature(mTouchedLatLng, properties);
    }
}
