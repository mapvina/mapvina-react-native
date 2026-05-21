import type * as Preset from "@docusaurus/preset-classic";
import type { Config } from "@docusaurus/types";
import { themes as prismThemes } from "prism-react-renderer";

const config: Config = {
  title: "MapVina React Native",
  tagline:
    "React Native library for creating maps with MapVina Native for Android & iOS.",
  headTags: [
    {
      tagName: "link",
      attributes: {
        rel: "icon",
        href: "/mapvina-react-native/favicons/light.svg",
        type: "image/svg+xml",
      },
    },
    {
      tagName: "link",
      attributes: {
        rel: "icon",
        href: "/mapvina-react-native/favicons/light.svg",
        type: "image/svg+xml",
        media: "(prefers-color-scheme: light)",
      },
    },
    {
      tagName: "link",
      attributes: {
        rel: "icon",
        href: "/mapvina-react-native/favicons/dark.svg",
        type: "image/svg+xml",
        media: "(prefers-color-scheme: dark)",
      },
    },
  ],

  url: "https://mapvina.com/",
  baseUrl: "/mapvina-react-native/",

  // GitHub pages deployment config.
  // If you aren't using GitHub pages, you don't need these.
  organizationName: "mapvina", // Usually your GitHub org/user name.
  projectName: "mapvina-react-native", // Usually your repo name.

  onBrokenLinks: "throw",
  markdown: {
    hooks: {
      onBrokenMarkdownLinks: "warn",
    },
  },

  i18n: {
    defaultLocale: "en",
    locales: ["en"],
  },

  presets: [
    [
      "classic",
      {
        docs: {
          path: "content",
          sidebarPath: "./sidebars.ts",
          editUrl:
            "https://github.com/mapvina/mapvina-react-native/tree/main/docs/",
        },
        theme: {
          customCss: "./src/css/custom.css",
        },
      } satisfies Preset.Options,
    ],
  ],

  themeConfig: {
    navbar: {
      title: "MapVina React Native",
      logo: {
        alt: "MapVina Logo",
        src: "logos/mapvina-logo-square-for-light-bg.svg",
        srcDark: "logos/mapvina-logo-square-for-dark-bg.svg",
      },
      items: [
        {
          type: "docSidebar",
          position: "left",
          sidebarId: "setup",
          label: "Setup",
        },
        {
          type: "docSidebar",
          position: "left",
          sidebarId: "guides",
          label: "Guides",
        },
        {
          type: "docSidebar",
          position: "left",
          sidebarId: "components",
          label: "Components",
        },
        {
          type: "docSidebar",
          position: "left",
          sidebarId: "modules",
          label: "Modules",
        },
        {
          type: "docSidebar",
          position: "left",
          sidebarId: "types",
          label: "Types",
        },
        {
          href: "https://github.com/mapvina/mapvina-react-native",
          label: "GitHub",
          position: "right",
        },
      ],
    },

    footer: {
      style: "dark",
      links: [
        {
          title: "Get Help",
          items: [
            {
              label: "GitHub Discussions",
              href: "https://github.com/mapvina/mapvina-react-native/discussions",
            },
            {
              label: "Slack",
              href: "https://osmus.slack.com/archives/C065DB4T2UB",
            },
          ],
        },
        {
          title: "MapVina Community",
          items: [
            {
              label: "BlueSky",
              href: "https://bsky.app/profile/mapvina.com",
            },
            {
              label: "Mastodon",
              href: "https://mastodon.social/@mapvina",
            },
            {
              label: "X",
              href: "https://twitter.com/mapvina",
            },
            {
              label: "LinkedIn",
              href: "https://www.linkedin.com/company/mapvina",
            },
            {
              label: "GitHub",
              href: "https://github.com/MapVina",
            },
          ],
        },
      ],
    },

    prism: {
      theme: prismThemes.github,
      darkTheme: prismThemes.dracula,
      additionalLanguages: ["diff", "ruby"],
    },

    algolia: {
      appId: "XPG24MVV4L",
      apiKey: "88a400aaa583423db0984b785c1de05b",
      indexName: "mapvina-react-native",
    },
  } satisfies Preset.ThemeConfig,
};

export default config;
