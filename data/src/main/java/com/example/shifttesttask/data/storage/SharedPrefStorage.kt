package com.example.shifttesttask.data.storage

import android.content.Context
import com.example.shifttesttask.data.models.SaveUserDataModel
import com.example.shifttesttask.domain.models.GreetingUserDataModel

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_USER_NAME = "name"
private const val KEY_USER_SURNAME = "surname"
private const val KEY_USER_PASSWORD = "password"

class SharedPrefStorage(context: Context) : UserDataStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveData(userData: SaveUserDataModel) {
        sharedPreferences.edit().putString(KEY_USER_NAME, userData.userName).apply()
        sharedPreferences.edit().putString(KEY_USER_SURNAME, userData.userSurname).apply()
        sharedPreferences.edit().putString(KEY_USER_PASSWORD, userData.userPassword).apply()
        println(userData.userName)
    }

    override fun loadGreetingData(): GreetingUserDataModel {
        val userName = sharedPreferences.getString(KEY_USER_NAME, "") ?: ""
        val userSurname = sharedPreferences.getString(KEY_USER_SURNAME, "") ?: ""
        return GreetingUserDataModel(userName = userName, userSurname = userSurname)
    }
}