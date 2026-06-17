#!/bin/bash
set -e

echo "=========================================="
echo "MapVina Flutter & React Native Publisher"
echo "=========================================="

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Directories
FLUTTER_DIR="/Volumes/DATA/MapVina/mapvina-migration-workspace/upstream-maplibre/flutter-mapvina-gl"
RN_DIR="/Volumes/DATA/MapVina/mapvina-migration-workspace/upstream-maplibre/mapvina-react-native"

# ==========================================
# 1. Check pub.dev login
# ==========================================
echo -e "\n${YELLOW}Checking pub.dev login...${NC}"
if dart pub auth 2>/dev/null | grep -q "Successfully signed in"; then
    echo -e "${GREEN}✓ pub.dev: Logged in${NC}"
else
    echo -e "${YELLOW}! pub.dev: Not logged in. Running dart pub login...${NC}"
    dart pub login
fi

# ==========================================
# 2. Check npm login
# ==========================================
echo -e "\n${YELLOW}Checking npm login...${NC}"
if npm whoami 2>/dev/null | grep -q "npm"; then
    echo -e "${GREEN}✓ npm: Logged in as $(npm whoami)${NC}"
else
    echo -e "${RED}✗ npm: Not logged in${NC}"
    echo -e "${YELLOW}Please run: npm login --auth-type=legacy${NC}"
    echo "Or set token: npm config set //registry.npmjs.org/:_authToken=YOUR_TOKEN"
    exit 1
fi

# ==========================================
# 3. Publish Flutter packages (in order)
# ==========================================
echo -e "\n${YELLOW}Publishing Flutter packages to pub.dev...${NC}"

# 3.1 Platform Interface
echo -e "\n${YELLOW}[1/3] Publishing mapvina_gl_platform_interface...${NC}"
cd "$FLUTTER_DIR/mapvina_gl_platform_interface"
dart pub publish --force
echo -e "${GREEN}✓ mapvina_gl_platform_interface published${NC}"

# Wait for pub.dev to index
sleep 30

# 3.2 Web Implementation
echo -e "\n${YELLOW}[2/3] Publishing mapvina_gl_web...${NC}"
cd "$FLUTTER_DIR/mapvina_gl_web"
dart pub publish --force
echo -e "${GREEN}✓ mapvina_gl_web published${NC}"

# Wait for pub.dev to index
sleep 30

# 3.3 Main Package
echo -e "\n${YELLOW}[3/3] Publishing mapvina_gl...${NC}"
cd "$FLUTTER_DIR/mapvina_gl"
dart pub publish --force
echo -e "${GREEN}✓ mapvina_gl published${NC}"

# ==========================================
# 4. Build & Publish React Native
# ==========================================
echo -e "\n${YELLOW}Building React Native package...${NC}"
cd "$RN_DIR"
yarn package prepack

echo -e "\n${YELLOW}Publishing @mapvina/mapvina-react-native to npm...${NC}"
cd "$RN_DIR/package"
npm publish --access public
echo -e "${GREEN}✓ @mapvina/mapvina-react-native published${NC}"

# ==========================================
# 5. Summary
# ==========================================
echo -e "\n=========================================="
echo -e "${GREEN}All packages published successfully!${NC}"
echo "=========================================="
echo ""
echo "Flutter packages:"
echo "  - https://pub.dev/packages/mapvina_gl_platform_interface"
echo "  - https://pub.dev/packages/mapvina_gl_web"
echo "  - https://pub.dev/packages/mapvina_gl"
echo ""
echo "React Native package:"
echo "  - https://www.npmjs.com/package/@mapvina/mapvina-react-native"
