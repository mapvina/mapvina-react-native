import {
  Camera,
  Map,
  Layer,
  UserLocation,
  Images,
} from "@mapvina/mapvina-react-native";
import { useState } from "react";
import { Button } from "react-native";

import mapvinaIcon from "@/assets/images/mapvina.png";
import { OSM_VECTOR_STYLE } from "@/constants/OSM_VECTOR_STYLE";

const MAPVINA_ICON = "mapvina-icon";

export function UserLocationForNavigation() {
  const [navigationActive, setNavigationActive] = useState(false);

  return (
    <>
      <Button
        title={`Navigation is ${navigationActive ? "active" : "inactive"}`}
        onPress={() => setNavigationActive((prevState) => !prevState)}
      />

      <Map
        mapStyle={OSM_VECTOR_STYLE}
        contentInset={navigationActive ? { top: 200 } : undefined}
        touchPitch={navigationActive}
      >
        <Images images={{ [MAPVINA_ICON]: mapvinaIcon }} />

        {navigationActive ? (
          <UserLocation heading>
            <Layer
              type="symbol"
              id="navigation-icon"
              layout={{
                "icon-image": MAPVINA_ICON,
                "icon-pitch-alignment": "map",
                "icon-allow-overlap": true,
              }}
            />
          </UserLocation>
        ) : null}

        <Camera
          trackUserLocation={navigationActive ? "heading" : undefined}
          zoom={navigationActive ? 19 : undefined}
          pitch={navigationActive ? 60 : undefined}
          onTrackUserLocationChange={(event) => {
            if (navigationActive && !event.nativeEvent.trackUserLocation) {
              setNavigationActive(false);
            }
          }}
        />
      </Map>
    </>
  );
}
