package com.example.shifttesttask.domain.repository

import com.example.shifttesttask.domain.models.GreetingUserDataModel
import com.example.shifttesttask.domain.models.UserDataModel

interface UserDataRepository {
    fun saveData(userData: UserDataModel)

    fun loadGreetingData() : GreetingUserDataModel

    fun checkRememberData() : Boolean

    fun clearRememberUserData()
}