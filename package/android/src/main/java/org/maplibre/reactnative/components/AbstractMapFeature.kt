package com.mapvina.reactnative.components

import android.content.Context
import com.facebook.react.views.view.ReactViewGroup
import com.mapvina.reactnative.components.mapview.MLRNMapView

abstract class AbstractMapFeature(
    context: Context?,
) : ReactViewGroup(context) {
    abstract fun addToMap(mapView: MLRNMapView)

    abstract fun removeFromMap(mapView: MLRNMapView)
}
