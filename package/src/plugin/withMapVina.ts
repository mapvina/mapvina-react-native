import { type ConfigPlugin, withPlugins } from "@expo/config-plugins";
import { android } from "./android";
import { ios } from "./ios";
import type { MapVinaPluginProps } from "./MapVinaPluginProps";

const withMapVina: ConfigPlugin<MapVinaPluginProps> = (config, props) => {
  return withPlugins(config, [
    [android.withGradleProperties, props],
    [ios.withPodfileGlobalVariables, props],
    [ios.withPodfilePostInstall, props],
  ]);
};

export default withMapVina;
