import {
  Layer,
  Map,
  RasterDEMSource,
  type StyleSpecification,
} from "@mapvina/mapvina-react-native";

const mapStyle: StyleSpecification = {
  version: 8,
  sources: {},
  layers: [
    {
      id: "background",
      type: "background",
      paint: {
        "background-color": "white",
      },
    },
  ],
};

export function Hillshade() {
  return (
    <Map mapStyle={mapStyle}>
      <RasterDEMSource url="https://tiles.mapterhorn.com/tilejson.json">
        <Layer type="hillshade" />
      </RasterDEMSource>
    </Map>
  );
}
