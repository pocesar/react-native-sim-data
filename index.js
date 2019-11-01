/// <reference path="extend.d.ts" />
'use strict';
Object.defineProperty(exports, "__esModule", { value: true });
const react_native_1 = require("react-native");
const RNSimData = react_native_1.NativeModules.RNSimDataModule;
exports.default = {
    getSimInfo() {
        return RNSimData;
    },
    getTelephoneNumber() {
        return RNSimData.phoneNumber0;
    },
    getRealtimeMcc(callback) {
        RNSimData.getRealtimeMcc(callback);
    },
    getRealtimeIccids(callback) {
        RNSimData.getRealtimeIccid(callback);
    },
    getCarrierName() {
        return RNSimData.carrierName0;
    },
    getCountryCode() {
        return RNSimData.countryCode0;
    }
};
//# sourceMappingURL=index.js.map
