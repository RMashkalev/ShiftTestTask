package com.example.shifttesttask.data.storage

import com.example.shifttesttask.data.models.SaveUserDataModel
import com.example.shifttesttask.domain.models.GreetingUserDataModel

interface UserDataStorage {

    fun saveData(userData: SaveUserDataModel)

    fun loadGreetingData() : GreetingUserDataModel

    fun checkRememberData() : Boolean

    fun clearRememberData()
}