---
sidebar_position: 3
---

# Library Customizations

It's possible to customize the native setup of the library. These props must be applied differently, based on
the project setup.

## Expo

When using Expo, simply add the customizations in the projects `app.json` or `app.config.{js,ts}`. Here is an
example customization for in a `app.config.ts`:

```ts
import type { MapVinaPluginProps } from "@mapvina/mapvina-react-native";

export default ({ config }: ConfigContext): ExpoConfig => ({
  ...config,
  plugins: [
    [
      "@mapvina/mapvina-react-native",
      {
        android: {
          nativeVersion: "x.x.x",
        },
        ios: {
          nativeVersion: "x.x.x",
        },
      } as MapVinaPluginProps,
    ],
  ],
});
```

## React Native

When using React Native, the customizations have to be applied differently for each platform.

### Android

On Android they are set in the `gradle.properties`, each of them prefixed with `io.github.mapvina.reactnative`. Example:

```diff
+ io.github.mapvina.reactnative.nativeVersion=x.x.x
```

### iOS

On iOS global variables in the `Podfile` are used, prefixed with `$MLRN`.

```diff
+ $MLRN_NATIVE_VERSION="x.x.x"

target "AppName" do
```

## Available Customizations

### Android

| Prop Key                            | Type                    | Description                                                                                                   |
| ----------------------------------- | ----------------------- | ------------------------------------------------------------------------------------------------------------- |
| `nativeVersion`                     | `VersionString`         | Version for [`io.github.mapvina.gl:android-sdk-*`](https://mvnrepository.com/artifact/io.github.mapvina.gl/android-sdk) |
| `nativeVariant`                     | `"opengl" \| "vulkan"`  | [Variant of `io.github.mapvina.gl:android-sdk-*`](#native-variant)                                                 |
| `pluginVersion`                     | `VersionString`         | Version for `io.github.mapvina.gl:android-plugin-*-v9`                                                             |
| `turfVersion`                       | `VersionString`         | Version for `io.github.mapvina.gl:android-sdk-turf`                                                                |
| `okhttpVersion`                     | `VersionString`         | Version for `com.squareup.okhttp3:okhttp`                                                                     |
| `locationEngine`                    | `"default" \| "google"` | [Location engine to be used](#location-engine)                                                                |
| `googlePlayServicesLocationVersion` | `VersionString`         | Version for `com.google.android.gms:play-services-location`, only used with `locationEngine: "google"`        |

For default values see [`gradle.properties` of the library](https://github.io/github/mapvina/mapvina-react-native/tree/main/android/gradle.properties).

#### Native Variant

You can choose between the current default OpenGL ES and the newer Vulkan rendering backend. Read more on the
[MapVina Native Release introducing Vulkan](https://github.io/github/mapvina/mapvina-native/releases/tag/android-v11.7.0).

#### Location Engine

Two location engines are available on Android:

- `default`
  - Default location engine provided by the device
  - Doesn't work with emulator
  - F-Droid compatible
- `google`
  - Google Play Services Location Engine
  - Possibly more accurate
  - Works with emulator
  - Not F-Droid compatible

### iOS

| Prop Key        | `Podfile` Global Variable | Type            | Description                                                                                                           |
| --------------- | ------------------------- | --------------- | --------------------------------------------------------------------------------------------------------------------- |
| `nativeVersion` | `$MLRN_NATIVE_VERSION`    | `VersionString` | Version for [`mapvina-gl-native-distribution`](https://github.io/github/mapvina/mapvina-gl-native-distribution/releases) |
| `spmSpec`       | `$MLRN_SPM_SPEC`          | `string`        | [Swift Package Manager Spec](#spm-spec)                                                                               |

For default values see [`mapvina-react-native.podspec` of the library](https://github.io/github/mapvina/mapvina-react-native/blob/main/mapvina-react-native.podspec).

#### SPM Spec

Setting a Swift Package Manager Spec allows further customization over setting the native version:

```rb
$MLRN_SPM_SPEC = {
  url: "https://github.io/github/mapvina/mapvina-gl-native-distribution",
  requirement: {
    kind: "upToNextMajorVersion",
    minimumVersion: "x.x.x"
  },
  product_name: "MapVina"
}
```
