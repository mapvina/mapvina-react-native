import { GeoJSONSource, Layer, Map } from "@mapvina/mapvina-react-native";
import { useEffect } from "react";
import Animated, {
  useAnimatedProps,
  useSharedValue,
  withTiming,
} from "react-native-reanimated";

import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";
import { colors } from "@/styles/colors";

const AnimatedGeoJSONSource = Animated.createAnimatedComponent(GeoJSONSource);

export const ReanimatedPoint = () => {
  const animatedFollowPoint = useSharedValue([0, 0]);

  useEffect(() => {
    animatedFollowPoint.value = withTiming([45, 45], { duration: 10000 });
  }, []);

  const animatedProps = useAnimatedProps(() => {
    const point: GeoJSON.Point = {
      type: "Point",
      coordinates: animatedFollowPoint.value,
    };

    return { data: JSON.stringify(point) };
  });

  return (
    <Map mapStyle={MAPVINA_DEMO_STYLE}>
      <AnimatedGeoJSONSource
        data={{ type: "Point", coordinates: [0, 0] }}
        animatedProps={animatedProps}
      >
        <Layer
          type="circle"
          id="circle"
          paint={{ "circle-radius": 20, "circle-color": colors.blue }}
        />
      </AnimatedGeoJSONSource>
    </Map>
  );
};
