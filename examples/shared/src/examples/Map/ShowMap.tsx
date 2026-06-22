import { Map } from "@mapvina-com/mapvina-react-native";

import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

export function ShowMap() {
  return <Map mapStyle={MAPVINA_DEMO_STYLE} />;
}
