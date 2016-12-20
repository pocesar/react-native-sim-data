'use strict'

import RNSimInfo from './RNSimInfo'

export default {
  getSimInfo() {
    return RNSimInfo
  },
  getTelephoneNumber() {
    return RNSimInfo.telephoneNumber1
  },
  getCarrierName() {
    return RNSimInfo.carrierName1
  },
  getCountryCode() {
    return RNSimInfo.countryCode1
  }
}