import { Map, TransformRequestManager } from "@mapvina-com/mapvina-react-native";
import { useLayoutEffect } from "react";
import { Text } from "react-native";

import { Bubble } from "@/components/Bubble";
import { MAPVINA_DEMO_STYLE } from "@/constants/MAPVINA_DEMO_STYLE";

export function Headers() {
  useLayoutEffect(() => {
    // Add header to all requests
    const idAll = TransformRequestManager.addHeader({
      name: "X-All-Request",
      value: "will-be-added-to-all-requests",
    });

    // Add header only to requests matching a regex pattern (string format)
    const idStyle = TransformRequestManager.addHeader({
      name: "X-Style-Only",
      value: "will-only-be-added-to-style-requests",
      match: "https://maps.mapvina.com/styles/v2/streets.json?key=public_key",
    });

    // Add header only to requests matching a regex pattern (RegExp object)
    const idTile = TransformRequestManager.addHeader({
      name: "X-Tile-Only",
      value: "will-only-be-added-to-tile-requests",
      match: /https:\/\/demotiles\.mapvina\.org\/tiles\//,
    });

    return () => {
      TransformRequestManager.removeHeader(idAll);
      TransformRequestManager.removeHeader(idStyle);
      TransformRequestManager.removeHeader(idTile);
    };
  }, []);

  return (
    <>
      <Map mapStyle={MAPVINA_DEMO_STYLE} />

      <Bubble>
        <Text>Inspect network traffic to observe HTTP headers.</Text>
      </Bubble>
    </>
  );
}
