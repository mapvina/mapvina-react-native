package io.github.mapvina.reactnative.components.location

import android.annotation.SuppressLint
import android.content.Context
import com.mapvina.android.location.modes.RenderMode
import com.mapvina.android.location.permissions.PermissionsManager
import com.mapvina.android.maps.MapVinaMap
import com.mapvina.android.maps.OnMapReadyCallback
import com.mapvina.android.maps.Style
import com.mapvina.android.maps.Style.OnStyleLoaded
import io.github.mapvina.reactnative.components.AbstractMapFeature
import io.github.mapvina.reactnative.components.mapview.MLRNMapView

class MLRNNativeUserLocation(
    context: Context?,
) : AbstractMapFeature(context),
    OnMapReadyCallback,
    OnStyleLoaded {
    private var enabled = true
    private var map: MapVinaMap? = null
    private var mapView: MLRNMapView? = null

    @RenderMode.Mode
    private var mRenderMode = RenderMode.COMPASS
    private var mPreferredFramesPerSecond = 0

    override fun addToMap(mapView: MLRNMapView) {
        enabled = true
        this.mapView = mapView
        mapView.getMapAsync(this)
        setRenderMode(mRenderMode)
        setPreferredFramesPerSecond(mPreferredFramesPerSecond)
    }

    override fun removeFromMap(mapView: MLRNMapView) {
        enabled = false
        if (map != null) map!!.getStyle(this)
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(mapVinaMap: MapVinaMap) {
        map = mapVinaMap
        mapVinaMap.getStyle(this)
    }

    @SuppressLint("MissingPermission")
    override fun onStyleLoaded(style: Style) {
        val context = getContext()
        if (!PermissionsManager.areLocationPermissionsGranted(context)) {
            return
        }

        val locationComponent = mapView!!.locationComponentManager
        locationComponent.update(style)
        locationComponent.showUserLocation(enabled)
    }

    fun setRenderMode(
        @RenderMode.Mode renderMode: Int,
    ) {
        mRenderMode = renderMode
        if (mapView != null) {
            val locationComponent = mapView!!.locationComponentManager
            locationComponent.setRenderMode(renderMode)
        }
    }

    fun setPreferredFramesPerSecond(framesPerSecond: Int) {
        mPreferredFramesPerSecond = framesPerSecond
        if (mapView != null) {
            val locationComponent = mapView!!.locationComponentManager
            locationComponent.setPreferredFramesPerSecond(framesPerSecond)
        }
    }
}
