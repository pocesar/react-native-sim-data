[![Build Status](https://travis-ci.org/pocesar/react-native-sim-data.svg?branch=master)](https://travis-ci.org/pocesar/react-native-sim-data) [![npm version](https://badge.fury.io/js/react-native-sim-data.svg)](https://badge.fury.io/js/react-native-sim-data)

# react-native-sim-data

React Native plugin to get the device's SIM data (carrier name, mcc mnc, country code, phone number, etc)

## Installation

```
$ npm i react-native-sim-data
$ react-native link react-native-sim-data
```

## Supported Platforms

- Android

## Usage

```es6
import RNSimData from 'react-native-sim-data'

RNSimData.getSimInfo()
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

//shortcut for RNSimData.getSimInfo().phoneNumber0
RNSimData.getTelephoneNumber()
//shortcut for RNSimData.getSimInfo().carrierName0
RNSimData.getCarrierName()
//shortcut for RNSimData.getSimInfo().countryCode0
RNSimData.getCountryCode()
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


