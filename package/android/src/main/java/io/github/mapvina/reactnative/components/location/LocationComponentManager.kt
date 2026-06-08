package io.github.mapvina.reactnative.components.location

import android.annotation.SuppressLint
import android.content.Context
import com.mapvina.android.location.LocationComponent
import com.mapvina.android.location.LocationComponentActivationOptions
import com.mapvina.android.location.LocationComponentOptions
import com.mapvina.android.location.OnCameraTrackingChangedListener
import com.mapvina.android.location.modes.CameraMode
import com.mapvina.android.location.modes.RenderMode
import com.mapvina.android.maps.MapVinaMap
import com.mapvina.android.maps.Style
import io.github.mapvina.reactnative.R
import io.github.mapvina.reactnative.components.mapview.MLRNMapView
import io.github.mapvina.reactnative.location.LocationManager

/**
 * The LocationComponent on android implements both location tracking and display of user's current location.
 * LocationComponentManager attempts to separate that, so that Camera can ask for location tracking independent of display of user current location.
 * And NativeUserLocation can ask for display of user's current location - independent of Camera's user tracking.
 */
class LocationComponentManager(
    mapView: MLRNMapView?,
    private val context: Context,
) {
    private var mMapView: MLRNMapView? = null
    private var mMap: MapVinaMap? = null

    private var mLocationManager: LocationManager? = null
    private var mLocationComponent: LocationComponent? = null

    @RenderMode.Mode
    private var mRenderMode: Int = RenderMode.COMPASS

    private var mShowUserLocation = false

    private var mFollowUserLocation = false

    private var mShowingUserLocation = false

    private var mOnCameraTrackingChangedListener: OnCameraTrackingChangedListener? = null

    init {
        mMapView = mapView
        mMap = mMapView?.mapVinaMap

        mLocationManager = LocationManager.getInstance(context)
    }

    fun showUserLocation(showUserLocation: Boolean) {
        mShowUserLocation = showUserLocation
        stateChanged()
    }

    fun setFollowUserLocation(followUserLocation: Boolean) {
        mFollowUserLocation = followUserLocation
        stateChanged()
    }

    fun setCameraMode(
        @CameraMode.Mode cameraMode: Int,
    ) {
        mLocationComponent?.cameraMode = cameraMode
    }

    fun setRenderMode(
        @RenderMode.Mode renderMode: Int,
    ) {
        mRenderMode = renderMode
        if (mShowingUserLocation) {
            mLocationComponent?.renderMode = renderMode
        }
    }

    fun setPreferredFramesPerSecond(preferredFramesPerSecond: Int) {
        if (preferredFramesPerSecond <= 0) {
            return
        }

        mLocationComponent?.setMaxAnimationFps(preferredFramesPerSecond)
    }

    fun addOnCameraTrackingChangedListener(onCameraTrackingChangedListener: OnCameraTrackingChangedListener?) {
        mOnCameraTrackingChangedListener?.let {
            mLocationComponent?.removeOnCameraTrackingChangedListener(
                it,
            )
        }

        mOnCameraTrackingChangedListener = onCameraTrackingChangedListener

        mOnCameraTrackingChangedListener?.let { mLocationComponent?.addOnCameraTrackingChangedListener(it) }
    }

    @SuppressLint("MissingPermission")
    private fun stateChanged() {
        mLocationComponent?.setLocationComponentEnabled((mFollowUserLocation || mShowUserLocation))

        if (mShowingUserLocation != mShowUserLocation) {
            updateShowUserLocation(mShowUserLocation)
        }

        if (mFollowUserLocation) {
            if (!mShowUserLocation) {
                mLocationComponent?.renderMode = RenderMode.GPS
            } else {
                mLocationComponent?.renderMode = mRenderMode
            }
            mLocationComponent?.onStart()
        } else {
            mLocationComponent?.cameraMode = CameraMode.NONE
        }
    }

    fun hasLocationComponent(): Boolean = (mLocationComponent != null)

    fun update(style: Style) {
        update(mShowUserLocation, style)
    }

    fun update(
        displayUserLocation: Boolean,
        style: Style,
    ) {
        val tintColor = mMapView?.tintColor

        if (mLocationComponent == null || tintColor != null) {
            mLocationComponent = mMap?.locationComponent

            val locationComponentActivationOptions: LocationComponentActivationOptions =
                LocationComponentActivationOptions
                    .builder(context, style)
                    .locationComponentOptions(options(displayUserLocation))
                    .build()
            mLocationComponent?.activateLocationComponent(locationComponentActivationOptions)
            mLocationComponent?.locationEngine = mLocationManager!!.engine
            mShowingUserLocation = displayUserLocation
        }

        updateShowUserLocation(displayUserLocation)
    }

    private fun updateShowUserLocation(displayUserLocation: Boolean) {
        if (mShowingUserLocation != displayUserLocation) {
            mLocationComponent?.applyStyle(options(displayUserLocation))
            mShowingUserLocation = displayUserLocation
        }
    }

    fun options(displayUserLocation: Boolean): LocationComponentOptions {
        var builder: LocationComponentOptions.Builder = LocationComponentOptions.builder(context)
        val tintColor = mMapView?.tintColor
        if (!displayUserLocation) {
            builder =
                builder
                    .padding(mMap?.getPadding())
                    .backgroundDrawable(R.drawable.empty)
                    .backgroundDrawableStale(R.drawable.empty)
                    .bearingDrawable(R.drawable.empty)
                    .foregroundDrawable(R.drawable.empty)
                    .foregroundDrawableStale(R.drawable.empty)
                    .gpsDrawable(R.drawable.empty)
                    .accuracyAlpha(0.0f)
        } else if (tintColor != null) {
            builder =
                builder
                    .enableStaleState(false)
                    .bearingTintColor(tintColor)
                    .foregroundTintColor(tintColor)
                    .accuracyColor(tintColor)
        }
        return builder.build()
    }
}
