package com.mapvina.reactnative.components.camera

import com.mapvina.android.camera.CameraUpdate
import com.mapvina.android.constants.MapVinaConstants
import com.mapvina.android.maps.MapVinaMap
import com.mapvina.android.maps.MapVinaMap.CancelableCallback
import com.mapvina.reactnative.components.camera.constants.CameraEasing
import java.lang.ref.WeakReference
import java.util.concurrent.ExecutionException
import java.util.concurrent.RunnableFuture
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class CameraUpdateItem(
    map: MapVinaMap?,
    private val cameraUpdate: CameraUpdate,
    private val duration: Int,
    @param:CameraEasing.Easing private val easing: Int,
    private val callback: CancelableCallback?,
) : RunnableFuture<Void?> {
    private var isCameraActionFinished = false
    private var isCameraActionCancelled = false

    private val mMap: WeakReference<MapVinaMap?> = WeakReference<MapVinaMap?>(map)

    override fun run() {
        val callback: CancelableCallback =
            object : CancelableCallback {
                override fun onCancel() {
                    handleCallbackResponse(true)
                }

                override fun onFinish() {
                    handleCallbackResponse(false)
                }
            }

        val map = mMap.get()
        if (map == null) {
            isCameraActionCancelled = true
            return
        }

        // animateCamera / easeCamera only allows positive duration
        if (this.duration == 0 || easing == CameraEasing.NONE) {
            map.moveCamera(cameraUpdate, callback)
            return
        }

        // On iOS a duration of -1 means default or dynamic duration (based on flight-path length)
        // On Android we can fallback to MapVina's default duration as there is no such API
        // TODO: Implement in MapVina Native Android
        val duration =
            if (this.duration < 0) MapVinaConstants.ANIMATION_DURATION else this.duration

        when (easing) {
            CameraEasing.LINEAR -> {
                map.easeCamera(cameraUpdate, duration, false, callback)
            }

            CameraEasing.EASE -> {
                map.easeCamera(cameraUpdate, duration, true, callback)
            }

            CameraEasing.FLY -> {
                map.animateCamera(cameraUpdate, duration, callback)
            }
        }
    }

    override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false

    override fun isCancelled(): Boolean = isCameraActionCancelled

    override fun isDone(): Boolean = isCameraActionFinished

    @Throws(InterruptedException::class, ExecutionException::class)
    override fun get(): Void? = null

    @Throws(InterruptedException::class, ExecutionException::class, TimeoutException::class)
    override fun get(
        timeout: Long,
        unit: TimeUnit,
    ): Void? = null

    private fun handleCallbackResponse(isCancel: Boolean) {
        if (callback == null) {
            return
        }

        isCameraActionCancelled = isCancel
        isCameraActionFinished = !isCancel

        if (isCancel) {
            callback.onCancel()
        } else {
            callback.onFinish()
        }
    }
}
