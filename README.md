[![Build Status](https://travis-ci.org/pocesar/react-native-sim-data.svg?branch=master)](https://travis-ci.org/pocesar/react-native-sim-data) [![npm version](https://badge.fury.io/js/react-native-sim-data.svg)](https://badge.fury.io/js/react-native-sim-data)

# react-native-sim

React Native plugin to get the device's SIM data (carrier name, mcc mnc, country code, phone number, etc)

## Installation

```
npm i react-native-sim-data
```

## Supported Platforms

- Android

## Usage

```es6
import RNSimInfo from 'react-native-sim'

RNSimInfo.getSimInfo()
/**
  the object has the following info (change 0 to access more than 1 SIM):

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
*/

//shortcut for RNSimInfo.getSimInfo().phoneNumber0
RNSimInfo.getTelephoneNumber()
//shortcut for RNSimInfo.getSimInfo().carrierName0
RNSimInfo.getCarrierName()
//shortcut for RNSimInfo.getSimInfo().countryCode0
RNSimInfo.getCountryCode()
```

### Caveats

Might crash if tries to use in a phone without any SIM cards.

### Permissions

This plugin uses two different Android APIs to receive SIM data:
- `TelephonyManager` (since API level 1)
- `SubscriptionManager` (since API level 22)

Since Android 6 (API level 23) a few methods of `TelephonyManager` require permission `READ_PHONE_STATE`.

All methods of `SubscriptionManager` require permission `READ_PHONE_STATE`.

`SubscriptionManager` is able to access multiple SIM data.


