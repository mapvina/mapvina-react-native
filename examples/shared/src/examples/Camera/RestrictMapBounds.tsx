import {
  Camera,
  Layer,
  Map,
  GeoJSONSource,
} from "@mapvina/mapvina-react-native";
import { bboxPolygon } from "@turf/bbox-polygon";

import { EU_BOUNDS } from "@/constants/GEOMETRIES";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";
import { colors } from "@/styles/colors";

const POLYGON = bboxPolygon(EU_BOUNDS);

export function RestrictMapBounds() {
  return (
    <Map mapStyle={MAPVINA_DEMO_STYLE}>
      <Camera maxBounds={EU_BOUNDS} bounds={EU_BOUNDS} />
      <GeoJSONSource id="bounds-source" data={POLYGON}>
        <Layer
          type="fill"
          id="bounds-fill"
          paint={{
            "fill-color": colors.blue,
            "fill-opacity": 0.1,
            "fill-outline-color": colors.blue,
          }}
        />
      </GeoJSONSource>
    </Map>
  );
}
