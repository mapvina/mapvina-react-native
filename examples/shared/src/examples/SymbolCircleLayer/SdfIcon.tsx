import {
  Images,
  Map,
  GeoJSONSource,
  Layer,
} from "@mapvina/mapvina-react-native";

import mapvinaSdfIcon from "@/assets/images/mapvina-sdf.png";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

export function SdfIcon() {
  return (
    <Map mapStyle={MAPVINA_DEMO_STYLE}>
      <Images
        images={{
          "example-icon": {
            source: mapvinaSdfIcon,
            sdf: true,
          },
        }}
      />
      <GeoJSONSource
        data={{
          type: "FeatureCollection",
          features: [
            {
              type: "Feature",
              geometry: { type: "Point", coordinates: [-20, 0] },
              properties: {
                color: "#95befa",
              },
            },
            {
              type: "Feature",
              geometry: { type: "Point", coordinates: [0, 0] },
              properties: {
                color: "#285daa",
              },
            },
            {
              type: "Feature",
              geometry: { type: "Point", coordinates: [20, 0] },
              properties: {
                color: "#ffffff",
              },
            },
          ],
        }}
      >
        <Layer
          type="symbol"
          layout={{
            "icon-image": "example-icon",
            "icon-size": 0.25,
            "icon-allow-overlap": true,
          }}
          paint={{
            "icon-color": ["get", "color"],
          }}
        />
      </GeoJSONSource>
    </Map>
  );
}
