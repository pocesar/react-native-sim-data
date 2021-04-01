/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {
  StyleSheet,
  View,
  Text,
  PermissionsAndroid,
} from 'react-native';
import RNSimData from 'react-native-sim-data'

class App extends React.Component {
  state = {
    data: {}
  }
  componentDidMount() {
    this.requestPermissions()
    this.getSimData()
  }

  getSimData() {
    const data = RNSimData.getSimInfo();
    const extracted = {
      isNetworkRoaming0: data.isNetworkRoaming0,
      mcc0: data.mcc0,
      subscriptionId0: data.subscriptionId0,
      simSerialNumber0: data.simSerialNumber0,
      carrierName0: data.carrierName0,
      isDataRoaming0: data.isDataRoaming0,
      phoneNumber0: data.phoneNumber0,
      mnc0: data.mnc0,
      simSlotIndex0: data.simSlotIndex0,
      deviceId0: data.deviceId0,
      displayName0: data.displayName0,
      countryCode0: data.countryCode0
    }
    this.setState({ extracted });
  }

  requestPermissions() {
    PermissionsAndroid.request(PermissionsAndroid.PERMISSIONS.READ_PHONE_STATE)
  }

  render() {
    return (

      <View style={styles.container}>
        <Text style={styles.welcome}>
          data: {this.state.extracted && JSON.stringify(this.state.extracted, null, 2)}
        </Text>
      </View>
    );
  }
}

export default App;


const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
