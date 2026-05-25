package io.github.mapvina.reactnative.components.sources.tilesources.vectorsource

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.module.annotations.ReactModule
import io.github.mapvina.reactnative.NativeVectorSourceModuleSpec
import io.github.mapvina.reactnative.utils.ExpressionParser
import io.github.mapvina.reactnative.utils.ReactTag
import io.github.mapvina.reactnative.utils.ReactTagResolver

@ReactModule(name = NativeVectorSourceModuleSpec.NAME)
class MLRNVectorSourceModule(
    reactContext: ReactApplicationContext,
    private val reactTagResolver: ReactTagResolver,
) : NativeVectorSourceModuleSpec(reactContext) {
    companion object {
        const val NAME = "MLRNVectorSourceModule"
    }

    private fun withViewportOnUIThread(
        reactTag: ReactTag,
        promise: Promise,
        fn: (MLRNVectorSource) -> Unit,
    ) {
        reactTagResolver.withViewResolved(reactTag.toInt(), promise, fn)
    }

    override fun querySourceFeatures(
        reactTag: Double,
        sourceLayer: String,
        filter: ReadableArray,
        promise: Promise,
    ) {
        withViewportOnUIThread(reactTag, promise) { vectorSource ->
            promise.resolve(
                vectorSource.querySourceFeatures(
                    mutableListOf(sourceLayer),
                    ExpressionParser.from(filter),
                ),
            )
        }
    }
}
