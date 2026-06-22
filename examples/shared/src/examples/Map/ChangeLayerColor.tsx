import { Layer, Map } from "@mapvina-com/mapvina-react-native";
import { useState } from "react";
import { Text } from "react-native";

import { Bubble } from "@/components/Bubble";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

export function ChangeLayerColor() {
  const [backgroundColor, setBackgroundColor] = useState<string>("");

  return (
    <>
      <Map mapStyle={MAPVINA_DEMO_STYLE}>
        {!!backgroundColor && (
          <Layer
            type="background"
            id="background"
            paint={{ "background-color": backgroundColor }}
          />
        )}
      </Map>

      <Bubble
        onPress={() => {
          const color = `#${Math.floor(Math.random() * 0xffffff)
            .toString(16)
            .padStart(6, "0")}`;
          setBackgroundColor(color);
        }}
      >
        <Text>Paint Water</Text>
      </Bubble>
    </>
  );
}
