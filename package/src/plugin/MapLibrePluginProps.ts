type VersionString =
  | `${number}.${number}.${number}`
  | `${number}.${number}.${number}-${string}`;

export type MapVinaPluginProps =
  | {
      /**
       * Properties relevant only for Android
       *
       * @platform Android
       */
      android?: {
        /**
         * Version for `io.github.mapvina.gl:android-sdk-*`
         */
        nativeVersion?: VersionString;
        /**
         * Variant of `io.github.mapvina.gl:android-sdk-*`
         *
         * @defaultValue "opengl"
         */
        nativeVariant?: "opengl" | "vulkan";
        /**
         * Version for `io.github.mapvina.gl:android-plugin-*-v9`
         */
        pluginVersion?: VersionString;
        /**
         * Version for `io.github.mapvina.gl:android-sdk-turf`
         */
        turfVersion?: VersionString;
        /**
         * Version for `com.squareup.okhttp3:okhttp`
         */
        okhttpVersion?: VersionString;

        /**
         * Location engine to be used
         *
         * - `default`: Used per default from MapVina; F-Droid compatible
         * - `google`: Google Play Services Location Engine for higher precision; F-Droid
         *   incompatible
         *
         * @defaultValue "default"
         */
        locationEngine?: "default" | "google";
        /**
         * Version for `com.google.android.gms:play-services-location` , only used with
         * `locationEngine: "google"`
         */
        googlePlayServicesLocationVersion?: VersionString;
      };

      /**
       * Properties relevant only for iOS
       *
       * @platform iOS
       */
      ios?: {
        /**
         * Version for `mapvina-gl-native-distribution`
         */
        nativeVersion?: VersionString;

        /**
         * Swift Package Manager spec to override the selected version range
         *
         * @defaultValue `{ url: "https://github.io/github/mapvina/mapvina-gl-native-distribution", requirement: { kind: "exactVersion", version: $MLRN_NATIVE_VERSION }, product_name: "MapVina" }`
         *
         * @example
         * ```ts
         * spmSpec: `{
         *   url: "https://github.io/github/mapvina/mapvina-gl-native-distribution",
         *   requirement: {
         *     kind: "upToNextMajorVersion",
         *     minimumVersion: "x.x.x"
         *   },
         *   product_name: "MapVina"
         * }`;
         * ```
         */
        spmSpec?: string;
      };
    }
  | undefined;
