package com.mapvina.reactnative.components.mapview.helpers

import com.mapvina.android.style.layers.CircleLayer
import com.mapvina.android.style.layers.FillExtrusionLayer
import com.mapvina.android.style.layers.FillLayer
import com.mapvina.android.style.layers.HeatmapLayer
import com.mapvina.android.style.layers.HillshadeLayer
import com.mapvina.android.style.layers.Layer
import com.mapvina.android.style.layers.LineLayer
import com.mapvina.android.style.layers.RasterLayer
import com.mapvina.android.style.layers.SymbolLayer

internal class LayerSourceInfo(
    layer: Layer?,
) {
    val sourceId: String

    val sourceLayerId: String?

    init {
        when (layer) {
            is CircleLayer -> {
                val symbolLayer = layer
                sourceId = symbolLayer.getSourceId()
                sourceLayerId = symbolLayer.getSourceLayer()
            }

            is FillExtrusionLayer -> {
                val fillExtrusionLayer = layer
                sourceId = fillExtrusionLayer.getSourceId()
                sourceLayerId = fillExtrusionLayer.getSourceLayer()
            }

            is FillLayer -> {
                val fillLayer = layer
                sourceId = fillLayer.getSourceId()
                sourceLayerId = fillLayer.getSourceLayer()
            }

            is HeatmapLayer -> {
                val heatmapLayer = layer
                sourceId = heatmapLayer.getSourceId()
                sourceLayerId = heatmapLayer.getSourceLayer()
            }

            is HillshadeLayer -> {
                val hillshadeLayer = layer
                sourceId = hillshadeLayer.getSourceId()
                sourceLayerId = null
            }

            is LineLayer -> {
                val lineLayer = layer
                sourceId = lineLayer.getSourceId()
                sourceLayerId = lineLayer.getSourceLayer()
            }

            is RasterLayer -> {
                val rasterLayer = layer
                sourceId = rasterLayer.getSourceId()
                sourceLayerId = null
            }

            is SymbolLayer -> {
                val symbolLayer = layer
                sourceId = symbolLayer.getSourceId()
                sourceLayerId = symbolLayer.getSourceLayer()
            }

            else -> {
                sourceId = ""
                sourceLayerId = null
            }
        }
    }
}
