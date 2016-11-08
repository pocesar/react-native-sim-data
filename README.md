# react-native-sim
React Native plugin to get the device's SIM data (carrier name, mcc mnc, country code, phone number, etc)

## Installation 

## Supported Platforms

- Android
- [wip] iOS

## Usage

## Android setup

### Requirements

Install `Extras` / `Android Support Library` from Android SDK.

### Permissions

This plugin uses two different Android APIs to receive SIM data:
- `TelephonyManager` (since API level 1)
- `SubscriptionManager` (since API level 22)

Since Android 6 (API level 23) a few methods of `TelephonyManager` require permission `READ_PHONE_STATE`.

All methods of `SubscriptionManager` require permission `READ_PHONE_STATE`.

`SubscriptionManager` is able to access multiple SIM data. The return object of this cordova plugin provides the details of the available sim cards in an array (`cards`).


