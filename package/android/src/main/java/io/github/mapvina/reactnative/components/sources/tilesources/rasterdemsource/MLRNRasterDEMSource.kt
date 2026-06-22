package io.github.mapvina.reactnative.components.sources.tilesources.rasterdemsource

import android.content.Context
import io.github.mapvina.android.style.sources.RasterDemSource
import io.github.mapvina.reactnative.components.sources.tilesources.MLRNTileSource

class MLRNRasterDEMSource(
    context: Context?,
) : MLRNTileSource<RasterDemSource?>(context) {
    var tileSize: Int? = null
    var encoding: String? = null

    override fun makeSource(): RasterDemSource {
        val configurationUrl = url
        val resolvedTileSize = (if (tileSize != null) tileSize else RasterDemSource.DEFAULT_TILE_SIZE)!!
        if (configurationUrl != null) {
            return RasterDemSource(mID, configurationUrl, resolvedTileSize)
        }

        return RasterDemSource(mID, buildTileset(), resolvedTileSize)
    }

    override fun buildTileset(): io.github.mapvina.android.style.sources.TileSet {
        val tileSet = super.buildTileset()
        encoding?.let { tileSet.encoding = it }
        return tileSet
    }
}
