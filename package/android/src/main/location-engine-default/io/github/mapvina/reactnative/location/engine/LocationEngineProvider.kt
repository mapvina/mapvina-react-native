package io.github.mapvina.reactnative.location.engine

import android.content.Context
import io.github.mapvina.android.location.engine.LocationEngine

class LocationEngineProvider : LocationEngineProvidable {
    override fun getLocationEngine(context: Context): LocationEngine = DefaultLocationEngineProvider().getLocationEngine(context)
}
