import {
  Camera,
  Map,
  NativeUserLocation,
} from "@mapvina-com/mapvina-react-native";
import { useState } from "react";

import { TabBarView } from "@/components/TabBarView";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

const OPTIONS = ["red", "yellow", "green"].map((data) => ({
  label: data,
  data,
}));

export function SetTintColor() {
  const [tintColor, setTintColor] = useState(OPTIONS[0]!.data);

  return (
    <TabBarView
      options={OPTIONS}
      onOptionPress={(_index, data) => {
        setTintColor(data);
      }}
    >
      <Map mapStyle={MAPVINA_DEMO_STYLE} tintColor={tintColor}>
        <Camera zoom={6} trackUserLocation="heading" />

        <NativeUserLocation mode="heading" />
      </Map>
    </TabBarView>
  );
}
