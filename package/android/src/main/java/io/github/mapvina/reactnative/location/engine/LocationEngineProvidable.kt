package io.github.mapvina.reactnative.location.engine

import android.content.Context
import io.github.mapvina.android.location.engine.LocationEngine

interface LocationEngineProvidable {
    fun getLocationEngine(context: Context): LocationEngine
}
