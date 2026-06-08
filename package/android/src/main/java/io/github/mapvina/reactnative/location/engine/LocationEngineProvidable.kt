package io.github.mapvina.reactnative.location.engine

import android.content.Context
import com.mapvina.android.location.engine.LocationEngine

interface LocationEngineProvidable {
    fun getLocationEngine(context: Context): LocationEngine
}
