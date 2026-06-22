import { Layer, Map, VectorSource } from "@mapvina-com/mapvina-react-native";
import type { VectorSourceRef } from "@mapvina-com/mapvina-react-native";
import { useRef, useState } from "react";
import { Text } from "react-native";

import { Bubble } from "@/components/Bubble";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

export function CustomVectorSource() {
  const vectorSourceRef = useRef<VectorSourceRef>(null);
  const [featuresCount, setFeaturesCount] = useState<number>();

  return (
    <>
      <Map mapStyle={MAPVINA_DEMO_STYLE}>
        <VectorSource
          id="mapvina-tiles"
          url="https://demotiles.mapvina.com/tiles/tiles.json"
          ref={vectorSourceRef}
          onPress={(event) => {
            event.persist();

            console.log(
              `VectorSource onPress: ${event.nativeEvent.features}`,
              event.nativeEvent.features,
            );
          }}
        >
          <Layer
            type="fill"
            id="countries"
            source-layer="countries"
            paint={{
              "fill-color": "#ffffff",
              "fill-antialias": true,
            }}
          />
        </VectorSource>
      </Map>
      <Bubble
        onPress={async () => {
          const features = await vectorSourceRef.current?.querySourceFeatures({
            sourceLayer: "countries",
          });

          setFeaturesCount(features?.length);
        }}
      >
        <Text>Query features</Text>
        {typeof featuresCount === "number" ? (
          <Text>Count: {featuresCount}</Text>
        ) : null}
      </Bubble>
    </>
  );
}
