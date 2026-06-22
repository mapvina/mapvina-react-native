import {
  Camera,
  LocationManager,
  Map,
  UserLocation,
} from "@mapvina-com/mapvina-react-native";
import { useEffect, useState } from "react";

import { TabBarView } from "@/components/TabBarView";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

const OPTIONS = [0, 5, 10].map((data) => ({ label: data + " Meter", data }));

export function UserLocationDisplacement() {
  const [minDisplacement, setMinDisplacement] = useState(OPTIONS[0]!.data);

  useEffect(() => {
    LocationManager.start();

    return () => {
      LocationManager.stop();
    };
  }, []);

  return (
    <TabBarView
      options={OPTIONS}
      onOptionPress={(_index, data) => {
        setMinDisplacement(data);
      }}
    >
      <Map mapStyle={MAPVINA_DEMO_STYLE}>
        <Camera trackUserLocation="heading" zoom={16} />

        <UserLocation minDisplacement={minDisplacement} />
      </Map>
    </TabBarView>
  );
}
