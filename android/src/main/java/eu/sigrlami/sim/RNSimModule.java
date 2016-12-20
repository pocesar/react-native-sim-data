package eu.sigrlami.sim;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import javax.annotation.Nullable;

public class RNSimModule extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;

  public RNSimModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNSimInfo";
  }

  @Override
  public @Nullable Map<String, Object> getConstants() {

    final Map<String, Object> constants = new HashMap<>();

    PackageManager packageManager = this.reactContext.getPackageManager();
    String packageName            = this.reactContext.getPackageName();

    TelephonyManager telManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

    int phoneCount = 0;
    int activeSubscriptionInfoCount = 0;
    int activeSubscriptionInfoCountMax = 0;

    try {
      if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
        if (simPermissionGranted(Manifest.permission.READ_PHONE_STATE)) {
          phoneCount = manager.getPhoneCount();
          SubscriptionManager manager = (SubscriptionManager) cntx.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
          activeSubscriptionInfoCount = manager.getActiveSubscriptionInfoCount();
          activeSubscriptionInfoCountMax = manager.getActiveSubscriptionInfoCountMax();

          List<SubscriptionInfo> subscriptionInfos = manager.getActiveSubscriptionInfoList();
          int sub = 1;
          for (SubscriptionInfo subInfo : subscriptionInfos) {
            sub++;
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
            boolean networkRoaming   = telManager.isNetworkRoaming(simSlotIndex);
            String deviceId          = telManager.getDeviceId(simSlotIndex);

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

            sims.put(simData);
          }
        }
      }
    } catch (JSONException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return constants;
  }
}