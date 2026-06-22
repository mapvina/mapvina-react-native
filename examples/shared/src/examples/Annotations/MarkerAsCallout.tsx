import {
  type LngLat,
  Map,
  Marker,
  GeoJSONSource,
  Layer,
  Images,
} from "@mapvina-com/mapvina-react-native";
import { useState } from "react";
import { Text, View } from "react-native";

import mapvinaIcon from "@/assets/images/mapvina.png";
import { FEATURE_COLLECTION } from "@/constants/GEOMETRIES";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

const MAPVINA_ICON = "mapvina-icon";

export function MarkerAsCallout() {
  const [selectedFeature, setSelectedFeature] =
    useState<GeoJSON.Feature<GeoJSON.Point, { name: string }>>();

  return (
    <Map mapStyle={MAPVINA_DEMO_STYLE}>
      <Images images={{ [MAPVINA_ICON]: mapvinaIcon }} />

      <GeoJSONSource
        data={FEATURE_COLLECTION}
        onPress={(event) => {
          const feature = event.nativeEvent.features[0] as
            | GeoJSON.Feature<GeoJSON.Point, { name: string }>
            | undefined;

          setSelectedFeature(feature);
        }}
      >
        <Layer
          type="symbol"
          id="symbol-layer"
          layout={{
            "icon-allow-overlap": true,
            "icon-anchor": "center",
            "icon-image": MAPVINA_ICON,
            "icon-size": 1,
          }}
        />
      </GeoJSONSource>

      {selectedFeature && (
        <Marker
          lngLat={selectedFeature.geometry.coordinates as LngLat}
          anchor="center"
          offset={[0, -48]}
        >
          <View
            style={{
              backgroundColor: "white",
              padding: 8,
            }}
          >
            <Text>{selectedFeature?.properties?.name}</Text>
          </View>
        </Marker>
      )}
    </Map>
  );
}
