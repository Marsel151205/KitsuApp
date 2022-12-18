package com.example.kitsu.data.local.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("sign", Context.MODE_PRIVATE)

    operator fun invoke() = preferences

    private fun remove(key: String) {
        preferences.edit().remove(key).apply()
    }
}