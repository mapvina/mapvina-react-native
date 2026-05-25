package io.github.mapvina.reactnative.components.mapview

import android.content.Context
import android.util.AttributeSet
import io.github.mapvina.android.maps.MapVinaMapOptions

class MLRNAndroidTextureMapView(
    context: Context,
    options: MapVinaMapOptions?,
) : MLRNMapView(context, options) {
    constructor(context: Context) : this(context, options = null)

    @Suppress("UNUSED_PARAMETER")
    constructor(context: Context, attrs: AttributeSet?) : this(context, options = null)

    @Suppress("UNUSED_PARAMETER")
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        options = null,
    )

    companion object {
        const val LOG_TAG: String = "MLRNAndroidTextureMapView"
    }
}
