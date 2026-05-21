package com.mapvina.reactnative.events

import android.graphics.PointF
import com.facebook.react.bridge.WritableMap
import com.mapvina.android.geometry.LatLng
import com.mapvina.geojson.Feature
import com.mapvina.reactnative.utils.GeoJSONUtils

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
