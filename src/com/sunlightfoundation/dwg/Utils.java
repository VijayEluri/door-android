package com.sunlightfoundation.dwg;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class Utils {
	
	public static void savePin(Context context, String pin) {
		context.getSharedPreferences("sunlight-door", 0).edit().putString("pin", pin).commit();
    }
    
    public static String getPin(Context context) {
    	return context.getSharedPreferences("sunlight-door", 0).getString("pin", null);
    }
    
    public static String doorUrl(Context context) {
    	return context.getResources().getString(R.string.door_url);
    }
    
    public static String deviceId(Context context) {
    	if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_TELEPHONY))
	        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
	    else
	        return Secure.getString(context.getContentResolver(), Secure.ANDROID_ID); 
    }
    
    public static void alert(Context context, String text) {
    	Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
	
}