package com.bruno.bootstrap;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by bruno on 16/4/19.
 */
public class PreferenceUtils {
    private SharedPreferences sharedPreferences;

    private SharedPreferences.Editor shareEditor;

    private static PreferenceUtils preferenceUtils = null;

    protected PreferenceUtils(Context context) {
        sharedPreferences = context.getSharedPreferences("SP", Context.MODE_PRIVATE);
        shareEditor = sharedPreferences.edit();
    }

    public static PreferenceUtils getInstance(Context context) {
        if (preferenceUtils == null) {
            synchronized (PreferenceUtils.class) {
                if (preferenceUtils == null) {
                    preferenceUtils = new PreferenceUtils(context);
                }
            }
        }
        return preferenceUtils;
    }

    public String getStringParam(String key) {
        return getStringParam(key, "");
    }

    public String getStringParam(String key, String defaultString) {
        return sharedPreferences.getString(key, defaultString);
    }

    public void saveParam(String key, String value) {
        shareEditor.putString(key, value).commit();
    }
}
