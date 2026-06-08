package io.github.mapvina.reactnative.components.sources.tilesources.rastersource

import android.content.Context
import com.mapvina.android.style.sources.RasterSource
import io.github.mapvina.reactnative.components.sources.tilesources.MLRNTileSource

class MLRNRasterSource(
    context: Context?,
) : MLRNTileSource<RasterSource?>(context) {
    var tileSize: Int? = null

    override fun makeSource(): RasterSource {
        validate()

        val tileSize = (if (tileSize != null) tileSize else RasterSource.DEFAULT_TILE_SIZE)!!

        if (!url.isNullOrEmpty()) {
            return RasterSource(mID, url, tileSize)
        }

        return RasterSource(mID, buildTileset(), tileSize)
    }
}
