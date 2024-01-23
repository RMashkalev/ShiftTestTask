package com.example.shifttesttask.data.storage

import android.content.Context
import com.example.shifttesttask.data.models.SaveUserDataModel
import com.example.shifttesttask.domain.models.GreetingUserDataModel

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_USER_NAME = "name"
private const val KEY_USER_SURNAME = "surname"
private const val KEY_USER_PASSWORD = "password"
private const val KEY_USER_BIRTHDAY = "password"

class SharedPrefStorage(context: Context) : UserDataStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveData(userData: SaveUserDataModel) {
        sharedPreferences.edit().putString(KEY_USER_NAME, userData.userName).apply()
        sharedPreferences.edit().putString(KEY_USER_SURNAME, userData.userSurname).apply()
        sharedPreferences.edit().putString(KEY_USER_PASSWORD, userData.userPassword).apply()
        sharedPreferences.edit().putString(KEY_USER_BIRTHDAY, userData.userBirthday).apply()
    }

    override fun loadGreetingData(): GreetingUserDataModel {
        val userName = sharedPreferences.getString(KEY_USER_NAME, "") ?: ""
        val userSurname = sharedPreferences.getString(KEY_USER_SURNAME, "") ?: ""
        return GreetingUserDataModel(userName = userName, userSurname = userSurname)
    }

    override fun checkRememberData(): Boolean {
        return sharedPreferences.contains(KEY_USER_NAME) && sharedPreferences.contains(KEY_USER_PASSWORD)
    }

    override fun clearRememberData() {
        sharedPreferences.edit().clear().apply()
    }
}