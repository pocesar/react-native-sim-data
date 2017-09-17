#!/bin/bash

npm install @types/react-native
npm run prepublishOnly
npm link
cd Example
npm install
npm link react-native-sim-data
react-native link react-native-sim-data
cd android && chmod +x gradlew && ./gradlew assembleDebug && ./gradlew assembleRelease
