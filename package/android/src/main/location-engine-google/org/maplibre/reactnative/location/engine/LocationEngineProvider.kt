package com.mapvina.reactnative.location.engine

import android.content.Context
import com.mapvina.android.location.engine.LocationEngine

class LocationEngineProvider : LocationEngineProvidable {
    override fun getLocationEngine(context: Context): LocationEngine = GoogleLocationEngineProvider().getLocationEngine(context)
}
