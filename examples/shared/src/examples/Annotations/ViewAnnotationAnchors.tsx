import { ViewAnnotation } from "@mapvina/mapvina-react-native";

import { AbstractAnchors } from "./AbstractAnchors";

export function ViewAnnotationAnchors() {
  return <AbstractAnchors AnnotationComponent={ViewAnnotation} />;
}
