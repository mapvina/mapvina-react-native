package io.github.mapvina.reactnative.components.sources.tilesources.vectorsource

import android.content.Context
import androidx.annotation.Size
import com.facebook.react.bridge.WritableArray
import io.github.mapvina.android.style.expressions.Expression
import io.github.mapvina.android.style.sources.VectorSource
import io.github.mapvina.reactnative.components.sources.tilesources.MLRNPressableTileSource
import io.github.mapvina.reactnative.utils.GeoJSONUtils

class MLRNVectorSource(
    context: Context,
) : MLRNPressableTileSource<VectorSource>(context) {
    override fun makeSource(): VectorSource {
        validate()

        if (!url.isNullOrEmpty()) {
            return VectorSource(mID, url)
        }

        return VectorSource(mID, buildTileset())
    }

    fun querySourceFeatures(
        @Size(min = 1) layerIDs: MutableList<String>,
        filter: Expression?,
    ): WritableArray? {
        if (source == null) {
            return null
        }

        val features =
            source!!.querySourceFeatures(layerIDs.toTypedArray<String>(), filter)

        return GeoJSONUtils.fromFeatureList(features)
    }
}
