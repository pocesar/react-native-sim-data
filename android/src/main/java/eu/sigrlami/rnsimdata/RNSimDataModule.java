package eu.sigrlami.rnsimdata;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableNativeArray;

public class RNSimDataModule extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;

  public RNSimDataModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNSimDataModule";
  }

  @ReactMethod
  public void getRealtimeMcc(Callback callback) {
    try {
      TelephonyManager telManager = (TelephonyManager) this.reactContext.getSystemService(Context.TELEPHONY_SERVICE);
      WritableNativeArray result = new WritableNativeArray();

      SubscriptionManager manager = (SubscriptionManager) this.reactContext.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
      List<SubscriptionInfo> subscriptionInfos = manager.getActiveSubscriptionInfoList();
      for (SubscriptionInfo subInfo : subscriptionInfos) {
          int mcc             = subInfo.getMcc();
          result.pushString(Integer.toString(mcc));
      }
      callback.invoke(result);
    } catch (Exception e) {
      e.printStackTrace();
      callback.invoke(new String(""));
    }
  }

  @ReactMethod
  public void getRealtimeIccid(Callback callback) {
    try {
      TelephonyManager telManager = (TelephonyManager) this.reactContext.getSystemService(Context.TELEPHONY_SERVICE);
      WritableNativeArray result = new WritableNativeArray();

      SubscriptionManager manager = (SubscriptionManager) this.reactContext.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
      List<SubscriptionInfo> subscriptionInfos = manager.getActiveSubscriptionInfoList();
      for (SubscriptionInfo subInfo : subscriptionInfos) {
          String iccId             = subInfo.getIccId();
          result.pushString(iccId);
      }
      callback.invoke(result);
    } catch (Exception e) {
      e.printStackTrace();
      callback.invoke(new String(""));
    }
  }


  @Override
  public Map<String, Object> getConstants() {

    final Map<String, Object> constants = new HashMap<>();

    try {
      TelephonyManager telManager = (TelephonyManager) this.reactContext.getSystemService(Context.TELEPHONY_SERVICE);

      SubscriptionManager manager = (SubscriptionManager) this.reactContext.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
      List<SubscriptionInfo> subscriptionInfos = manager.getActiveSubscriptionInfoList();

      int sub = 0;
      for (SubscriptionInfo subInfo : subscriptionInfos) {
        CharSequence carrierName = subInfo.getCarrierName();
        String countryIso        = subInfo.getCountryIso();
        int dataRoaming          = subInfo.getDataRoaming();  // 1 is enabled ; 0 is disabled
        CharSequence displayName = subInfo.getDisplayName();
        String iccId             = subInfo.getIccId();
        int mcc                  = subInfo.getMcc();
        int mnc                  = subInfo.getMnc();
        String number            = subInfo.getNumber();
        int simSlotIndex         = subInfo.getSimSlotIndex();
        int subscriptionId       = subInfo.getSubscriptionId();
        boolean networkRoaming   = telManager.isNetworkRoaming();
        String deviceId          = telManager.getDeviceId(simSlotIndex);
        //String deviceId          = telManager.getImei(simSlotIndex) || telManager.getMeid(simSlotIndex);

        constants.put("carrierName" + sub, carrierName.toString());
        constants.put("displayName" + sub, displayName.toString());
        constants.put("countryCode" + sub, countryIso);
        constants.put("mcc" + sub, mcc);
        constants.put("mnc" + sub, mnc);
        constants.put("isNetworkRoaming" + sub, networkRoaming);
        constants.put("isDataRoaming"    + sub, (dataRoaming == 1));
        constants.put("simSlotIndex"     + sub, simSlotIndex);
        constants.put("phoneNumber"      + sub, number);
        constants.put("deviceId"         + sub, deviceId);
        constants.put("simSerialNumber"  + sub, iccId);
        constants.put("subscriptionId"   + sub, subscriptionId);
        sub++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return constants;
  }
}
