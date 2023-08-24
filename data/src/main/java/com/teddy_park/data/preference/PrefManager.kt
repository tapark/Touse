package com.teddy_park.data.preference

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@SuppressLint("StaticFieldLeak")
object PrefManager {

    private lateinit var context: Context
    private lateinit var prefs: SharedPreferences

    private const val KEY_INIT_PREF_MANAGER = "KEY_INIT_PREF_MANAGER"

    const val KEY_APP_LANGUAGE = "KEY_APP_LANGUAGE"
    const val KET_LOGIN_USER_INFO = "KET_LOGIN_USER_INFO"
    const val APP_DEFAULT_LANGUAGE = "en"

    fun init(mContext: Context) {
        context = mContext
        prefs = context.getSharedPreferences(KEY_INIT_PREF_MANAGER, Context.MODE_PRIVATE)
    }

    fun putString(key: String, value: String) = prefs.edit().putString(key, value).apply()
    fun getString(key: String, defaultValue: String) = prefs.getString(key, defaultValue) ?: APP_DEFAULT_LANGUAGE

    fun putBoolean(key: String, value: Boolean) = prefs.edit().putBoolean(key, value).apply()
    fun getBoolean(key: String, defaultValue: Boolean) = prefs.getBoolean(key, defaultValue)

    fun putInt(key: String, value: Int) = prefs.edit().putInt(key, value).apply()
    fun getInt(key: String, defaultValue: Int) = prefs.getInt(key, defaultValue)

    fun putFloat(key: String, value: Float) = prefs.edit().putFloat(key, value).apply()
    fun getFloat(key: String, defaultValue: Float) = prefs.getFloat(key, defaultValue)

    fun putLong(key: String, value: Long) = prefs.edit().putLong(key, value).apply()
    fun getLong(key: String, defaultValue: Long) = prefs.getLong(key, defaultValue)

    fun remove(key: String) = prefs.edit().remove(key).apply()

//    fun putLoginUserInfo(value: SaveLoginInfo) {
//        val json = Gson().toJson(value)
//        prefs.edit().putString(KET_LOGIN_USER_INFO, json).apply()
//    }
//    fun getLoginUserInfo(): SaveLoginInfo? {
//        val json = prefs.getString(KET_LOGIN_USER_INFO, null)
//        return Gson().fromJson(json, object: TypeToken<SaveLoginInfo>() {}.type)
//    }
//    fun deleteLoginUserInfo() {
//        prefs.edit().remove(KET_LOGIN_USER_INFO).apply()
//    }
//
//    fun getCookieInfo(): String? {
//        return getLoginUserInfo()?.cookie
//    }
}
