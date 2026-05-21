package com.mapvina.reactnative.components.sources.tilesources

import android.content.Context
import com.mapvina.android.style.sources.Source
import com.mapvina.reactnative.components.sources.MLRNSource

abstract class MLRNTileSource<T : Source?>(
    context: Context?,
) : MLRNSource<T?>(context),
    TileSourceInterface {
    override var url: String? = null
    override var tiles: MutableCollection<String>? = null

    override var attribution: String? = null

    override var minZoom: Int? = null
    override var maxZoom: Int? = null

    override var scheme: String? = null
}
