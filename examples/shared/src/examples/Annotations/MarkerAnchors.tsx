import { Marker } from "@mapvina/mapvina-react-native";

import { AbstractAnchors } from "./AbstractAnchors";

export function MarkerAnchors() {
  return <AbstractAnchors AnnotationComponent={Marker} />;
}
