'use strict'

import RNSimInfo, { IRNSimInfo } from './RNSimInfo'

export default {
  getSimInfo() {
    return RNSimInfo
  },
  getTelephoneNumber() {
    return RNSimInfo.phoneNumber1
  },
  getCarrierName() {
    return RNSimInfo.carrierName1
  },
  getCountryCode() {
    return RNSimInfo.countryCode1
  }
}