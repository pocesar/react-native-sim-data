#!/bin/bash

npm install react react-native @types/react @types/react-native --no-save
npm run compile
npm link
cd Example
npm install
npm link react-native-sim-data
#react-native link react-native-sim-data
cd android && chmod +x gradlew && ./gradlew clean && ./gradlew assembleDebug && cd ..
npm test
