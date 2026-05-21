import {
  GeoJSONSource,
  Images,
  type ImagesProps,
  Layer,
  Map,
} from "@mapvina/mapvina-react-native";
import { useState } from "react";

import mapvinaIcon from "@/assets/images/mapvina.png";
import { FEATURE_COLLECTION } from "@/constants/GEOMETRIES";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

export function GeoJSONSourceIcon() {
  const [images, setImages] = useState<ImagesProps["images"]>({
    [FEATURE_COLLECTION.features[0]!.properties.name]: mapvinaIcon,
  });

  return (
    <Map mapStyle={MAPVINA_DEMO_STYLE}>
      <Images
        images={images}
        onImageMissing={({ nativeEvent: { image } }) => {
          console.log("onImageMissing", image);

          setImages((prevState) => ({
            ...prevState,
            [image]: mapvinaIcon,
          }));
        }}
      />
      <GeoJSONSource data={FEATURE_COLLECTION}>
        <Layer
          type="symbol"
          id="symbol-layer"
          layout={{
            "icon-image": ["get", "name"],
          }}
        />
      </GeoJSONSource>
    </Map>
  );
}
