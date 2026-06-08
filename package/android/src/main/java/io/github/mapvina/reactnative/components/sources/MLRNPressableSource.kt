package io.github.mapvina.reactnative.components.sources

import android.content.Context
import android.graphics.PointF
import android.graphics.RectF
import com.facebook.react.bridge.ReadableMap
import com.mapvina.android.geometry.LatLng
import com.mapvina.android.style.sources.Source
import com.mapvina.geojson.Feature
import io.github.mapvina.reactnative.events.MapPressEventWithFeatures

abstract class MLRNPressableSource<T : Source?>(
    context: Context?,
) : MLRNSource<T>(context) {
    var hasOnPress: Boolean = false

    var hitbox: RectF? = null
        get() {
            if (!hasOnPress) {
                return null
            }
            return field ?: DEFAULT_HITBOX
        }

    fun setReactHitbox(map: ReadableMap?) {
        hitbox =
            if (map != null) {
                RectF(
                    map.getDouble("left").toFloat(),
                    map.getDouble("top").toFloat(),
                    map.getDouble("right").toFloat(),
                    map.getDouble("bottom").toFloat(),
                )
            } else {
                null
            }
    }

    fun onPress(
        features: MutableList<Feature>,
        latLng: LatLng,
        screenPoint: PointF,
    ) {
        eventDispatcher?.dispatchEvent(
            MapPressEventWithFeatures(
                surfaceId,
                id,
                "onPress",
                latLng,
                screenPoint,
                features,
            ),
        )
    }

    companion object {
        const val LOG_TAG: String = "MLRNPressableSource"

        val DEFAULT_HITBOX: RectF = RectF(22.0f, 22.0f, 22.0f, 22.0f)
    }
}
