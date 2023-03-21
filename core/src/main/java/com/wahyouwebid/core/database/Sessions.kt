package com.wahyouwebid.core.database

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

@SuppressLint("CommitPrefEdits")
class Sessions constructor(
    val context: Context
) {
    companion object {
        const val keyAlias: String = "_androidx_security_master_key_"
        const val secretSharedPref: String = "secret_shared_prefs"
        const val token: String = "token"
    }

    private var editor: SharedPreferences.Editor? = null
    private val spec = KeyGenParameterSpec.Builder(
        keyAlias,
        KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
    )
        .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
        .setKeySize(256)
        .build()

    private val masterKey: MasterKey = MasterKey.Builder(context)
        .setKeyGenParameterSpec(spec)
        .build()

    private val pref = EncryptedSharedPreferences.create(
        context,
        secretSharedPref,
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    init {
        editor = pref.edit()
    }

    fun batch() = pref

    fun putString(key: String, value: String) {
        editor!!.putString(key, value)
        editor!!.commit()
    }

    fun putInt(key: String, value: Int) {
        editor!!.putInt(key, value)
        editor!!.commit()
    }

    fun putLong(key: String, value: Long) {
        editor!!.putLong(key, value)
        editor!!.commit()
    }

    fun putBoolean(key: String, value: Boolean) {
        editor!!.putBoolean(key, value)
        editor!!.commit()
    }

    fun getString(key: String): String {
        return pref.getString(key, "").toString()
    }

    fun getInt(key: String): Int {
        return pref.getInt(key, 0)
    }

    fun getInt(key: String, defValue: Int = 0): Int {
        return pref.getInt(key, defValue)
    }

    fun getBoolean(key: String): Boolean {
        return pref.getBoolean(key, false)
    }

    fun logOut() {
        editor!!.clear()
        editor!!.commit()
    }
}