/**
*  @providesModule react-native-sim-data
*/
/// <reference path="extend.d.ts" />

'use strict'

import { NativeModules } from 'react-native'

export interface RNSimData {
  carrierName0: string;
  displayName0: string;
  countryCode0: string;
  mcc0: string;
  mnc0: string;
  isNetworkRoaming0: string;
  isDataRoaming0: string;
  simSlotIndex0: string;
  phoneNumber0: string;
  deviceId0: string;
  simSerialNumber0: string;
  subscriptionId0: string;
  carrierName1: string;
  displayName1: string;
  countryCode1: string;
  mcc1: string;
  mnc1: string;
  isNetworkRoaming1: string;
  isDataRoaming1: string;
  simSlotIndex1: string;
  phoneNumber1: string;
  deviceId1: string;
  simSerialNumber1: string;
  subscriptionId1: string;
}

const RNSimInfo: RNSimData = NativeModules.RNSimData

export default {
  getSimInfo() {
    return RNSimInfo
  },
  getTelephoneNumber() {
    return RNSimInfo.phoneNumber0
  },
  getCarrierName() {
    return RNSimInfo.carrierName0
  },
  getCountryCode() {
    return RNSimInfo.countryCode0
  }
}