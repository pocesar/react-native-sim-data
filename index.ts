'use strict'

import RNSimInfo, { IRNSimInfo } from './RNSimInfo'

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