package io.github.mapvina.reactnative

import com.facebook.react.BaseReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider
import com.facebook.react.uimanager.ViewManager
import io.github.mapvina.reactnative.components.annotations.callout.MLRNCalloutManager
import io.github.mapvina.reactnative.components.annotations.markerview.MLRNMarkerViewManager
import io.github.mapvina.reactnative.components.annotations.pointannotation.MLRNPointAnnotationManager
import io.github.mapvina.reactnative.components.camera.MLRNCameraManager
import io.github.mapvina.reactnative.components.camera.MLRNCameraModule
import io.github.mapvina.reactnative.components.images.MLRNImagesManager
import io.github.mapvina.reactnative.components.layer.MLRNLayerManager
import io.github.mapvina.reactnative.components.location.MLRNNativeUserLocationManager
import io.github.mapvina.reactnative.components.mapview.MLRNAndroidTextureMapViewManager
import io.github.mapvina.reactnative.components.mapview.MLRNMapViewManager
import io.github.mapvina.reactnative.components.mapview.MLRNMapViewModule
import io.github.mapvina.reactnative.components.sources.geojsonsource.MLRNGeoJSONSourceManager
import io.github.mapvina.reactnative.components.sources.geojsonsource.MLRNGeoJSONSourceModule
import io.github.mapvina.reactnative.components.sources.imagesource.MLRNImageSourceManager
import io.github.mapvina.reactnative.components.sources.tilesources.rasterdemsource.MLRNRasterDEMSourceManager
import io.github.mapvina.reactnative.components.sources.tilesources.rastersource.MLRNRasterSourceManager
import io.github.mapvina.reactnative.components.sources.tilesources.vectorsource.MLRNVectorSourceManager
import io.github.mapvina.reactnative.components.sources.tilesources.vectorsource.MLRNVectorSourceModule
import io.github.mapvina.reactnative.modules.MLRNLocationModule
import io.github.mapvina.reactnative.modules.MLRNLogModule
import io.github.mapvina.reactnative.modules.MLRNNetworkModule
import io.github.mapvina.reactnative.modules.MLRNOfflineModule
import io.github.mapvina.reactnative.modules.MLRNStaticMapModule
import io.github.mapvina.reactnative.modules.MLRNTransformRequestModule
import io.github.mapvina.reactnative.utils.ReactTagResolver

class MLRNPackage : BaseReactPackage() {
    override fun getModule(
        name: String,
        reactContext: ReactApplicationContext,
    ): NativeModule? {
        when (name) {
            MLRNMapViewModule.NAME -> return MLRNMapViewModule(
                reactContext,
                getReactTagResolver(reactContext),
            )

            MLRNCameraModule.NAME -> return MLRNCameraModule(
                reactContext,
                getReactTagResolver(reactContext),
            )

            MLRNGeoJSONSourceModule.NAME -> return MLRNGeoJSONSourceModule(
                reactContext,
                getReactTagResolver(reactContext),
            )

            MLRNVectorSourceModule.NAME -> return MLRNVectorSourceModule(
                reactContext,
                getReactTagResolver(reactContext),
            )

            MLRNOfflineModule.NAME -> return MLRNOfflineModule(reactContext)

            MLRNStaticMapModule.NAME -> return MLRNStaticMapModule(reactContext)

            MLRNLocationModule.NAME -> return MLRNLocationModule(reactContext)

            MLRNLogModule.NAME -> return MLRNLogModule(reactContext)

            MLRNNetworkModule.NAME -> return MLRNNetworkModule(reactContext)

            MLRNTransformRequestModule.NAME -> return MLRNTransformRequestModule(reactContext)
        }

        return null
    }

    override fun getReactModuleInfoProvider(): ReactModuleInfoProvider =
        ReactModuleInfoProvider {
            val moduleInfos = HashMap<String, ReactModuleInfo>()

            moduleInfos.put(MLRNMapViewModule.NAME,
                ReactModuleInfo(MLRNMapViewModule.NAME, MLRNMapViewModule.NAME,
                    false, true, false, true))

            moduleInfos.put(MLRNCameraModule.NAME,
                ReactModuleInfo(MLRNCameraModule.NAME, MLRNCameraModule.NAME,
                    false, false, false, true))

            moduleInfos.put(MLRNGeoJSONSourceModule.NAME,
                ReactModuleInfo(MLRNGeoJSONSourceModule.NAME, MLRNGeoJSONSourceModule.NAME,
                    false, false, false, true))

            moduleInfos.put(MLRNVectorSourceModule.NAME,
                ReactModuleInfo(MLRNVectorSourceModule.NAME, MLRNVectorSourceModule.NAME,
                    false, false, false, true))

            moduleInfos.put(MLRNOfflineModule.NAME,
                ReactModuleInfo(MLRNOfflineModule.NAME, MLRNOfflineModule.NAME,
                    false, false, false, true))

            moduleInfos.put(MLRNStaticMapModule.NAME,
                ReactModuleInfo(MLRNStaticMapModule.NAME, MLRNStaticMapModule.NAME,
                    false, false, false, true))

            moduleInfos.put(MLRNLocationModule.NAME,
                ReactModuleInfo(MLRNLocationModule.NAME, MLRNLocationModule.NAME,
                    false, false, false, true))

            moduleInfos.put(MLRNLogModule.NAME,
                ReactModuleInfo(MLRNLogModule.NAME, MLRNLogModule.NAME,
                    false, false, false, true))

            moduleInfos.put(MLRNNetworkModule.NAME,
                ReactModuleInfo(MLRNNetworkModule.NAME, MLRNNetworkModule.NAME,
                    false, false, false, true))

            moduleInfos.put(MLRNTransformRequestModule.NAME,
                ReactModuleInfo(MLRNTransformRequestModule.NAME, MLRNTransformRequestModule.NAME,
                    false, false, false, true))

            moduleInfos
        }

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        val managers: MutableList<ViewManager<*, *>> = mutableListOf()

        // components
        managers.add(MLRNCameraManager(reactContext))
        managers.add(MLRNMapViewManager(reactContext))
        managers.add(MLRNMarkerViewManager(reactContext))
        managers.add(MLRNAndroidTextureMapViewManager(reactContext))
        managers.add(MLRNPointAnnotationManager(reactContext))
        managers.add(MLRNCalloutManager())
        managers.add(MLRNNativeUserLocationManager())

        // sources
        managers.add(MLRNImageSourceManager(reactContext))
        managers.add(MLRNGeoJSONSourceManager(reactContext))
        managers.add(MLRNRasterSourceManager(reactContext))
        managers.add(MLRNRasterDEMSourceManager(reactContext))
        managers.add(MLRNVectorSourceManager(reactContext))

        // images
        managers.add(MLRNImagesManager(reactContext))

        // layers
        managers.add(MLRNLayerManager())

        return managers
    }

    private var reactTagResolver: ReactTagResolver? = null

    private fun getReactTagResolver(context: ReactApplicationContext): ReactTagResolver {
        val reactTagResolver = reactTagResolver
        if (reactTagResolver == null) {
            val result = ReactTagResolver(context)
            this.reactTagResolver = result
            return result
        }
        return reactTagResolver
    }
}
