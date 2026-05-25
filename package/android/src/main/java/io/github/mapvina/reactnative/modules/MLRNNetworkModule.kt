package io.github.mapvina.reactnative.modules

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import io.github.mapvina.android.MapVina
import io.github.mapvina.reactnative.NativeNetworkModuleSpec

@ReactModule(name = MLRNNetworkModule.NAME)
class MLRNNetworkModule(
    reactContext: ReactApplicationContext,
) : NativeNetworkModuleSpec(reactContext) {
    companion object {
        const val NAME = "MLRNNetworkModule"
    }

    override fun getName() = NAME

    private val context: ReactApplicationContext = reactContext

    override fun setConnected(connected: Boolean) {
        context.runOnUiQueueThread {
            MapVina.setConnected(connected)
        }
    }
}
