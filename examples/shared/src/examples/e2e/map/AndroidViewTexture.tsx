import { Map } from "@mapvina/mapvina-react-native";

import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

export function AndroidViewTexture() {
  return (
    <Map testID="map" mapStyle={MAPVINA_DEMO_STYLE} androidView="texture" />
  );
}
