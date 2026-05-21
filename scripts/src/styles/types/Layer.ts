import type { LayerSpecification } from "@mapvina/mapvina-gl-style-spec";

import type { LayerProperty } from "./LayerProperty";

export type Layer = {
  name: LayerSpecification["type"] | "light";
  properties: LayerProperty[];
};
