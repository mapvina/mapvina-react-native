import { Map, type MapRef } from "@mapvina-com/mapvina-react-native";
import { useRef, useState } from "react";
import { Text } from "react-native";

import { Bubble } from "@/components/Bubble";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

export function SourceLayerVisibility() {
  const mapRef = useRef<MapRef>(null);
  const [visible, setVisible] = useState(true);

  return (
    <>
      <Map ref={mapRef} mapStyle={MAPVINA_DEMO_STYLE} />
      <Bubble
        onPress={() => {
          mapRef.current?.setSourceVisibility(
            !visible,
            "mapvina",
            "countries",
          );

          setVisible((prevState) => !prevState);
        }}
      >
        <Text>{`${visible ? "Hide" : "Show"} Countries`}</Text>
      </Bubble>
    </>
  );
}
