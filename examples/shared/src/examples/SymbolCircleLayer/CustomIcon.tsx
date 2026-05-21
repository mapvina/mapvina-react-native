import {
  Map,
  type MapRef,
  GeoJSONSource,
  Layer,
  Images,
} from "@mapvina/mapvina-react-native";
import { useRef, useState } from "react";
import { Text } from "react-native";

import mapvinaIcon from "../../assets/images/mapvina.png";

import { Bubble } from "@/components/Bubble";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

const MAPVINA_ICON = "mapvina-icon";

export function CustomIcon() {
  const mapRef = useRef<MapRef>(null);
  const [geometries, setGeometries] = useState<GeoJSON.Point[]>([]);

  return (
    <>
      <Map
        ref={mapRef}
        mapStyle={MAPVINA_DEMO_STYLE}
        onPress={async (event) => {
          const point: GeoJSON.Point = {
            type: "Point",
            coordinates: event.nativeEvent.lngLat,
          };

          setGeometries((prev) => [...prev, point]);
        }}
      >
        <Images images={{ [MAPVINA_ICON]: mapvinaIcon }} />

        <GeoJSONSource
          hitbox={{ top: 10, right: 10, bottom: 10, left: 10 }}
          onPress={(event) => {
            console.log(
              "Layer pressed, queried features:",
              event.nativeEvent.features,
              event.nativeEvent.lngLat,
              event.nativeEvent.point,
            );
          }}
          data={{ type: "GeometryCollection", geometries }}
        >
          <Layer
            type="symbol"
            layout={{
              "icon-image": MAPVINA_ICON,
              "icon-allow-overlap": true,
            }}
          />
        </GeoJSONSource>
      </Map>

      <Bubble>
        <Text>Tap to add an icon</Text>
      </Bubble>
    </>
  );
}
