import { type LngLat, Map, type MapRef } from "@mapvina/mapvina-react-native";
import { useRef, useState } from "react";
import { Button } from "react-native";
import { z } from "zod";

import { AssertZod } from "@/components/AssertZod";
import { Bubble } from "@/components/Bubble";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

export function GetCenter() {
  const mapRef = useRef<MapRef>(null);
  const [result, setResult] = useState<LngLat>();

  return (
    <>
      <Map ref={mapRef} testID="map" mapStyle={MAPVINA_DEMO_STYLE} />
      <Bubble>
        <Button
          title="Act"
          onPress={async () => {
            setResult(await mapRef.current?.getCenter());
          }}
        />

        <AssertZod
          schema={z.tuple([
            z.number().min(-0.1).max(0.1),
            z.number().min(-0.1).max(0.1),
          ])}
          actual={result}
        />
      </Bubble>
    </>
  );
}
