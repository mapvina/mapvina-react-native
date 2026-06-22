import { Map, type MapRef } from "@mapvina-com/mapvina-react-native";
import { useRef, useState } from "react";
import { Button } from "react-native";

import { AssertEquals } from "@/components/AssertEquals";
import { Bubble } from "@/components/Bubble";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

export function GetPitch() {
  const mapRef = useRef<MapRef>(null);
  const [result, setResult] = useState<number>();

  return (
    <>
      <Map ref={mapRef} testID="map" mapStyle={MAPVINA_DEMO_STYLE} />
      <Bubble>
        <Button
          title="Act"
          onPress={async () => {
            setResult(await mapRef.current?.getPitch());
          }}
        />

        <AssertEquals expect={0} actual={result} />
      </Bubble>
    </>
  );
}
