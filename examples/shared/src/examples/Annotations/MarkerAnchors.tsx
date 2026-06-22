import { Marker } from "@mapvina-com/mapvina-react-native";

import { AbstractAnchors } from "./AbstractAnchors";

export function MarkerAnchors() {
  return <AbstractAnchors AnnotationComponent={Marker} />;
}
