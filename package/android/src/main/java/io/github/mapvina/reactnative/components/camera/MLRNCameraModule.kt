package io.github.mapvina.reactnative.components.camera

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap
import io.github.mapvina.reactnative.NativeCameraModuleSpec
import io.github.mapvina.reactnative.utils.ReactTag
import io.github.mapvina.reactnative.utils.ReactTagResolver

class MLRNCameraModule(
    context: ReactApplicationContext,
    private val reactTagResolver: ReactTagResolver,
) : NativeCameraModuleSpec(context) {
    companion object {
        const val NAME = "MLRNCameraModule"
    }

    private fun withViewportOnUIThread(
        reactTag: ReactTag,
        reject: Promise,
        fn: (MLRNCamera) -> Unit,
    ) {
        reactTagResolver.withViewResolved(reactTag.toInt(), reject, fn)
    }

    override fun setStop(
        reactTag: ReactTag,
        stop: ReadableMap,
        promise: Promise,
    ) {
        withViewportOnUIThread(reactTag, promise) {
            it.handleImperativeStop(stop)
            promise.resolve(null)
        }
    }
}
