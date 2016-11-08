/**
*  @providesModule react-natove-sim
*/

var RNSimInfo = requite('react-native').NativeModules.RNSimInfo;

module.exports = {

    getSimInfo: function () {
	return RNSimInfo;
    },  
    getTelephoneNumber: function () {
	return RNSimInfo.telephoneNumber;
    },
    getCarrierName: function () {
	return RNSimInfo.carrierName;
    },
    getCountryCode: function () {
	return RNSimInfo.countryCode;
    }

};
