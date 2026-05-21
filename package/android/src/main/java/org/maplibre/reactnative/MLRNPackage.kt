package com.mapvina.reactnative

import com.facebook.react.BaseReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider
import com.facebook.react.uimanager.ViewManager
import com.mapvina.reactnative.components.annotations.callout.MLRNCalloutManager
import com.mapvina.reactnative.components.annotations.markerview.MLRNMarkerViewManager
import com.mapvina.reactnative.components.annotations.pointannotation.MLRNPointAnnotationManager
import com.mapvina.reactnative.components.camera.MLRNCameraManager
import com.mapvina.reactnative.components.camera.MLRNCameraModule
import com.mapvina.reactnative.components.images.MLRNImagesManager
import com.mapvina.reactnative.components.layer.MLRNLayerManager
import com.mapvina.reactnative.components.location.MLRNNativeUserLocationManager
import com.mapvina.reactnative.components.mapview.MLRNAndroidTextureMapViewManager
import com.mapvina.reactnative.components.mapview.MLRNMapViewManager
import com.mapvina.reactnative.components.mapview.MLRNMapViewModule
import com.mapvina.reactnative.components.sources.geojsonsource.MLRNGeoJSONSourceManager
import com.mapvina.reactnative.components.sources.geojsonsource.MLRNGeoJSONSourceModule
import com.mapvina.reactnative.components.sources.imagesource.MLRNImageSourceManager
import com.mapvina.reactnative.components.sources.tilesources.rasterdemsource.MLRNRasterDEMSourceManager
import com.mapvina.reactnative.components.sources.tilesources.rastersource.MLRNRasterSourceManager
import com.mapvina.reactnative.components.sources.tilesources.vectorsource.MLRNVectorSourceManager
import com.mapvina.reactnative.components.sources.tilesources.vectorsource.MLRNVectorSourceModule
import com.mapvina.reactnative.modules.MLRNLocationModule
import com.mapvina.reactnative.modules.MLRNLogModule
import com.mapvina.reactnative.modules.MLRNNetworkModule
import com.mapvina.reactnative.modules.MLRNOfflineModule
import com.mapvina.reactnative.modules.MLRNStaticMapModule
import com.mapvina.reactnative.modules.MLRNTransformRequestModule
import com.mapvina.reactnative.utils.ReactTagResolver

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
            val moduleInfos: MutableMap<String, ReactModuleInfo> = HashMap()

            moduleInfos[MLRNMapViewModule.NAME] =
                ReactModuleInfo(
                    MLRNMapViewModule.NAME,
                    MLRNMapViewModule.NAME,
                    canOverrideExistingModule = false,
                    needsEagerInit = true,
                    isCxxModule = false,
                    isTurboModule = true,
                )

            moduleInfos[MLRNCameraModule.NAME] =
                ReactModuleInfo(
                    MLRNCameraModule.NAME,
                    MLRNCameraModule.NAME,
                    canOverrideExistingModule = false,
                    needsEagerInit = false,
                    isCxxModule = false,
                    isTurboModule = true,
                )

            moduleInfos[MLRNGeoJSONSourceModule.NAME] =
                ReactModuleInfo(
                    MLRNGeoJSONSourceModule.NAME,
                    MLRNGeoJSONSourceModule.NAME,
                    canOverrideExistingModule = false,
                    needsEagerInit = false,
                    isCxxModule = false,
                    isTurboModule = true,
                )

            moduleInfos[MLRNVectorSourceModule.NAME] =
                ReactModuleInfo(
                    MLRNVectorSourceModule.NAME,
                    MLRNVectorSourceModule.NAME,
                    canOverrideExistingModule = false,
                    needsEagerInit = false,
                    isCxxModule = false,
                    isTurboModule = true,
                )

            moduleInfos[MLRNOfflineModule.NAME] =
                ReactModuleInfo(
                    MLRNOfflineModule.NAME,
                    MLRNOfflineModule.NAME,
                    canOverrideExistingModule = false,
                    needsEagerInit = false,
                    isCxxModule = false,
                    isTurboModule = true,
                )

            moduleInfos[MLRNStaticMapModule.NAME] =
                ReactModuleInfo(
                    MLRNStaticMapModule.NAME,
                    MLRNStaticMapModule.NAME,
                    canOverrideExistingModule = false,
                    needsEagerInit = false,
                    isCxxModule = false,
                    isTurboModule = true,
                )

            moduleInfos[MLRNLocationModule.NAME] =
                ReactModuleInfo(
                    MLRNLocationModule.NAME,
                    MLRNLocationModule.NAME,
                    canOverrideExistingModule = false,
                    needsEagerInit = false,
                    isCxxModule = false,
                    isTurboModule = true,
                )

            moduleInfos[MLRNLogModule.NAME] =
                ReactModuleInfo(
                    MLRNLogModule.NAME,
                    MLRNLogModule.NAME,
                    canOverrideExistingModule = false,
                    needsEagerInit = false,
                    isCxxModule = false,
                    isTurboModule = true,
                )

            moduleInfos[MLRNNetworkModule.NAME] =
                ReactModuleInfo(
                    MLRNNetworkModule.NAME,
                    MLRNNetworkModule.NAME,
                    canOverrideExistingModule = false,
                    needsEagerInit = false,
                    isCxxModule = false,
                    isTurboModule = true,
                )

            moduleInfos[MLRNTransformRequestModule.NAME] =
                ReactModuleInfo(
                    MLRNTransformRequestModule.NAME,
                    MLRNTransformRequestModule.NAME,
                    canOverrideExistingModule = false,
                    needsEagerInit = false,
                    isCxxModule = false,
                    isTurboModule = true,
                )

            moduleInfos
        }

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        val managers: MutableList<ViewManager<*, *>> = ArrayList()

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
