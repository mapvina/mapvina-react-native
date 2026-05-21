import { Map, type StyleSpecification } from "@mapvina/mapvina-react-native";
import { useState } from "react";
import { Text } from "react-native";

import MapVinaDemoStyleBlue from "@/assets/styles/mapvina-demo-style-blue.json";
import MapVinaDemoStyleWhite from "@/assets/styles/mapvina-demo-style-white.json";
import { Bubble } from "@/components/Bubble";

export function LocalStyleJSON() {
  const [color, setColor] = useState<"blue" | "white">("blue");

  return (
    <>
      <Map
        mapStyle={
          {
            blue: MapVinaDemoStyleBlue as StyleSpecification,
            white: MapVinaDemoStyleWhite as StyleSpecification,
          }[color]
        }
      />
      <Bubble
        onPress={() =>
          setColor((prevState) => {
            return ({ blue: "white", white: "blue" } as const)[prevState];
          })
        }
      >
        <Text>Switch Style JSON</Text>
      </Bubble>
    </>
  );
}
