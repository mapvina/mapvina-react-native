package io.github.mapvina.reactnative.events

import android.graphics.PointF
import com.facebook.react.bridge.WritableMap
import io.github.mapvina.android.geometry.LatLng
import io.github.mapvina.geojson.Feature
import io.github.mapvina.reactnative.utils.GeoJSONUtils

class MapPressEventWithFeatures(
    surfaceId: Int,
    viewId: Int,
    internalEventName: String,
    latLng: LatLng,
    screenPoint: PointF,
    private val features: List<Feature>,
) : MapPressEvent(surfaceId, viewId, internalEventName, latLng, screenPoint) {
    override fun getEventData(): WritableMap =
        super.getEventData().apply {
            putArray("features", GeoJSONUtils.fromFeatureList(features))
        }
}
