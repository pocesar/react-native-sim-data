#!/bin/bash

npm install @types/react-native
npm run prepublish
npm link
cd Example
npm install
npm link react-native-sim-data
react-native link react-native-sim-data
cd android && ./gradlew assembleDebug && ./gradlew assembleRelease
