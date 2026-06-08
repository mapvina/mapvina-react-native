package io.github.mapvina.reactnative.location.engine

import android.content.Context
import com.mapvina.android.location.engine.LocationEngine

class LocationEngineProvider : LocationEngineProvidable {
    override fun getLocationEngine(context: Context): LocationEngine = DefaultLocationEngineProvider().getLocationEngine(context)
}
