import { Map, type MapRef } from "@mapvina/mapvina-react-native";
import { useRef } from "react";
import { Button } from "react-native";

import { Bubble } from "@/components/Bubble";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

export function ShowAttribution() {
  const mapRef = useRef<MapRef>(null);

  return (
    <>
      <Map ref={mapRef} testID="map" mapStyle={MAPVINA_DEMO_STYLE} />
      <Bubble>
        <Button
          title="Act"
          onPress={async () => {
            await mapRef.current?.showAttribution();
          }}
        />
      </Bubble>
    </>
  );
}
