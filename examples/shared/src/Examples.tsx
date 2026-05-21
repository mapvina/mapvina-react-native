import { DefaultTheme, NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import {
  FlatList,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
} from "react-native";

import * as MapVinaE2E from "@/examples/e2e/index";
import * as MapVinaExamples from "@/examples/index";
import { colors } from "@/styles/colors";

const styles = StyleSheet.create({
  flex1: {
    flex: 1,
  },
  exampleListItem: {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
    paddingHorizontal: 16,
    height: 56,
  },

  exampleListItemBorder: {
    borderBottomColor: "#cccccc",
    borderBottomWidth: StyleSheet.hairlineWidth,
  },
  exampleListLabel: {
    fontSize: 18,
  },
});

type ExampleListItem = ExampleGroup | ExampleItem;

class ExampleItem {
  id: string;
  label: string;
  Component: any;

  constructor(label: string, Component: any, id?: string) {
    this.id = id || label;
    this.label = label;
    this.Component = Component;
  }
}

class ExampleGroup {
  id: string;
  root: boolean;
  label: string;
  items: ExampleListItem[];

  constructor(
    label: string,
    items: ExampleListItem[],
    root = false,
    id?: string,
  ) {
    this.id = id || label;
    this.root = root;
    this.label = label;
    this.items = items;
  }
}

const Examples = new ExampleGroup(
  "MapVina React Native",
  [
    new ExampleItem("Bug Report", MapVinaExamples.BugReport),

    new ExampleGroup("E2E Tests", [
      new ExampleGroup("Map", [
        new ExampleItem(
          "Map androidView='texture'",
          MapVinaE2E.Map.AndroidViewTexture,
        ),

        new ExampleItem("Map getBearing", MapVinaE2E.Map.GetBearing),
        new ExampleItem("Map getCenter", MapVinaE2E.Map.GetCenter),
        new ExampleItem("Map getPitch", MapVinaE2E.Map.GetPitch),
        new ExampleItem("Map getViewState", MapVinaE2E.Map.GetViewState),
        new ExampleItem("Map getZoom", MapVinaE2E.Map.GetZoom),
        new ExampleItem("Map project", MapVinaE2E.Map.Project),
        new ExampleItem(
          "Map queryRenderedFeatures",
          MapVinaE2E.Map.QueryRenderedFeatures,
        ),
        new ExampleItem("Map showAttribution", MapVinaE2E.Map.ShowAttribution),
        new ExampleItem("Map unproject", MapVinaE2E.Map.Unproject),
      ]),

      new ExampleGroup("GeoJSONSource", [
        new ExampleItem(
          "GeoJSONSource getData",
          MapVinaE2E.GeoJSONSource.GetData,
        ),
        new ExampleItem(
          "GeoJSONSource getClusterExpansionZoom",
          MapVinaE2E.GeoJSONSource.GetClusterExpansionZoom,
        ),
        new ExampleItem(
          "GeoJSONSource getClusterLeaves",
          MapVinaE2E.GeoJSONSource.GetClusterLeaves,
        ),
        new ExampleItem(
          "GeoJSONSource getClusterChildren",
          MapVinaE2E.GeoJSONSource.GetClusterChildren,
        ),
      ]),
    ]),

    new ExampleGroup("Map", [
      new ExampleItem("Show Map", MapVinaExamples.ShowMap),
      new ExampleItem("Local Style from JSON", MapVinaExamples.LocalStyleJSON),
      new ExampleItem("Show Click", MapVinaExamples.ShowClick),
      new ExampleItem(
        "Show Region did Change",
        MapVinaExamples.ShowRegionDidChange,
      ),
      new ExampleItem("Two Maps", MapVinaExamples.TwoMaps),
      new ExampleItem("Ornaments", MapVinaExamples.Ornaments),
      new ExampleItem(
        "Create Static Map from Map",
        MapVinaExamples.CreateStaticMapFromMap,
      ),

      new ExampleItem(
        "Project/Unproject between Coordinates/Pixel Point",
        MapVinaExamples.ProjectUnproject,
      ),
      new ExampleItem(
        "Show and hide a layer",
        MapVinaExamples.ShowAndHideLayer,
      ),
      new ExampleItem("Change Layer Color", MapVinaExamples.ChangeLayerColor),
      new ExampleItem(
        "Source Layer Visibility",
        MapVinaExamples.SourceLayerVisibility,
      ),
      new ExampleItem("Set Tint Color", MapVinaExamples.SetTintColor),
    ]),

    new ExampleGroup("Camera", [
      new ExampleItem(
        "Fit (Bounds, Center/Zoom, Padding)",
        MapVinaExamples.Fit,
      ),
      new ExampleItem("Set Pitch", MapVinaExamples.SetPitch),
      new ExampleItem("Set Bearing", MapVinaExamples.SetBearing),
      new ExampleItem("Fly To", MapVinaExamples.FlyTo),
      new ExampleItem("Restrict Bounds", MapVinaExamples.RestrictMapBounds),
      new ExampleItem("Yo-yo Camera", MapVinaExamples.YoYo),
      new ExampleItem("Get Zoom", MapVinaExamples.GetZoom),
      new ExampleItem("Get Center", MapVinaExamples.GetCenter),
    ]),

    new ExampleGroup("User Location", [
      new ExampleItem(
        "Follow User Location Alignment",
        MapVinaExamples.FollowUserLocationAlignment,
      ),
      new ExampleItem(
        "Follow User Location Render Mode",
        MapVinaExamples.FollowUserLocationRenderMode,
      ),
      new ExampleItem(
        "User Location for Navigation",
        MapVinaExamples.UserLocationForNavigation,
      ),
      new ExampleItem(
        "User Location Updates",
        MapVinaExamples.UserLocationUpdates,
      ),
      new ExampleItem(
        "User Location Displacement",
        MapVinaExamples.UserLocationDisplacement,
      ),

      new ExampleItem(
        "Set preferred Frames per Second\n(Android only)",
        MapVinaExamples.SetAndroidPreferredFramesPerSecond,
      ),
    ]),

    new ExampleGroup("Layers", [
      new ExampleItem(
        "ColorRelief with Mapterhorn",
        MapVinaExamples.ColorRelief,
      ),
      new ExampleItem("Hillshade with Mapterhorn", MapVinaExamples.Hillshade),
    ]),

    new ExampleGroup("Symbol/CircleLayer", [
      new ExampleItem("Custom Icon", MapVinaExamples.CustomIcon),
      new ExampleItem("SDF Icon", MapVinaExamples.SdfIcon),
      new ExampleItem("Clustering Earthquakes", MapVinaExamples.Earthquakes),
      new ExampleItem(
        "GeoJSONSource with Icons",
        MapVinaExamples.GeoJSONSourceIcon,
      ),
    ]),

    new ExampleGroup("Fill/RasterLayer", [
      new ExampleItem(
        "GeoJSONSource FeatureCollection",
        MapVinaExamples.GeoJSONSourceFeatureCollection,
      ),
      new ExampleItem(
        "OpenStreetMap Raster Tiles",
        MapVinaExamples.OpenStreetMapRasterTiles,
      ),
      new ExampleItem("Indoor Building Map", MapVinaExamples.IndoorBuilding),
      new ExampleItem(
        "Query Feature with Point",
        MapVinaExamples.QueryWithPoint,
      ),
      new ExampleItem(
        "Query Features with Bounding Box",
        MapVinaExamples.QueryWithBounds,
      ),
      new ExampleItem(
        "Custom Vector Source",
        MapVinaExamples.CustomVectorSource,
      ),
      new ExampleItem("Image Overlay", MapVinaExamples.ImageOverlay),

      new ExampleItem("Heatmap", MapVinaExamples.Heatmap),
    ]),

    new ExampleGroup("LineLayer", [
      new ExampleItem("Gradient Line", MapVinaExamples.GradientLine),
    ]),

    new ExampleGroup("Protocols", [
      new ExampleItem("PMTiles Map Style", MapVinaExamples.PMTilesMapStyle),
      new ExampleItem(
        "PMTiles Vector Source",
        MapVinaExamples.PMTilesVectorSource,
      ),
    ]),

    new ExampleGroup("Styles", [
      new ExampleItem("Style JSON Interop", MapVinaExamples.StyleJSONInterop),
    ]),

    new ExampleGroup("Annotations", [
      new ExampleItem("ViewAnnotation", MapVinaExamples.ViewAnnotation),
      new ExampleItem(
        "ViewAnnotation Anchors",
        MapVinaExamples.ViewAnnotationAnchors,
      ),
      new ExampleItem("Marker", MapVinaExamples.Marker),
      new ExampleItem("Marker Anchors", MapVinaExamples.MarkerAnchors),
      new ExampleItem("Marker as Callout", MapVinaExamples.MarkerAsCallout),
    ]),

    new ExampleGroup("Animated", [
      new ExampleItem(
        "Animate Circle along Line",
        MapVinaExamples.AnimateCircleAlongLine,
      ),
      new ExampleItem("Animated Length", MapVinaExamples.AnimatedLength),
      new ExampleItem("Animated Morph", MapVinaExamples.AnimatedMorph),
      new ExampleItem("Animated Size", MapVinaExamples.AnimatedSize),
      new ExampleItem("Reanimated Point", MapVinaExamples.ReanimatedPoint),
      new ExampleItem("Reanimated Marker", MapVinaExamples.ReanimatedMarker),
      new ExampleItem(
        "Reanimated ViewAnnotation",
        MapVinaExamples.ReanimatedViewAnnotation,
      ),
    ]),

    new ExampleGroup("OfflineManager", [
      new ExampleItem(
        "Create Offline Pack",
        MapVinaExamples.CreateOfflinePack,
      ),
      new ExampleItem("Cache Management", MapVinaExamples.CacheManagement),
    ]),

    new ExampleItem(
      "StaticMapManager: Create Image",
      MapVinaExamples.CreateStaticMapWithoutMap,
    ),

    new ExampleGroup("TransformRequestManager", [
      new ExampleItem("Transform URL", MapVinaExamples.TransformUrl),
      new ExampleItem("Headers", MapVinaExamples.Headers),
    ]),
  ],
  true,
);

function flatMapExamples(
  example: ExampleListItem,
  flattenedExamples: ExampleListItem[] = [],
  parentPath = "",
): ExampleListItem[] {
  if (example instanceof ExampleGroup) {
    const currentPath = parentPath
      ? `${parentPath} > ${example.label}`
      : example.label;
    example.id = currentPath;

    return [
      ...flattenedExamples,
      ...example.items.flatMap((item) =>
        flatMapExamples(item, [], currentPath),
      ),
      example,
    ];
  }

  example.id = parentPath ? `${parentPath} › ${example.label}` : example.label;

  return [...flattenedExamples, example];
}

const FlatExamples = flatMapExamples(Examples);

interface ExampleListProps {
  navigation: any;
  route: any;
}

function ExampleList({ route, navigation }: ExampleListProps) {
  const { name } = route;
  const example =
    FlatExamples.find((examples) => examples.id === name) || Examples;

  function itemPress(item: ExampleListItem) {
    navigation.navigate(item.id);
  }

  function renderItem({ item }: { item: ExampleListItem }) {
    return (
      <View style={styles.exampleListItemBorder}>
        <TouchableOpacity onPress={() => itemPress(item)}>
          <View style={styles.exampleListItem}>
            <Text style={styles.exampleListLabel}>{item.label}</Text>
            <Text style={{ fontSize: 24 }}>›</Text>
          </View>
        </TouchableOpacity>
      </View>
    );
  }

  return (
    <View style={styles.flex1}>
      <FlatList
        style={styles.flex1}
        data={example instanceof ExampleGroup ? example.items : []}
        keyExtractor={(item) => item.id}
        renderItem={renderItem}
      />
    </View>
  );
}

function buildNavigationScreens(
  example: ExampleListItem,
  Stack: ReturnType<typeof createStackNavigator>,
) {
  if (example instanceof ExampleGroup) {
    return (
      <Stack.Screen
        key={example.id}
        name={example.id}
        component={ExampleList}
        options={{ title: example.label }}
      />
    );
  }

  return (
    <Stack.Screen
      key={example.id}
      name={example.id}
      component={example.Component}
      options={{ title: example.label }}
    />
  );
}

export function Home() {
  const Stack = createStackNavigator();

  return (
    <NavigationContainer
      theme={{
        ...DefaultTheme,
        colors: {
          ...DefaultTheme.colors,
          card: colors.blue,
          primary: "#ffffff",
          background: "#ffffff",
          text: "#ffffff",
        },
      }}
    >
      <Stack.Navigator initialRouteName={Examples.id}>
        {FlatExamples.map((example) => buildNavigationScreens(example, Stack))}
      </Stack.Navigator>
    </NavigationContainer>
  );
}
