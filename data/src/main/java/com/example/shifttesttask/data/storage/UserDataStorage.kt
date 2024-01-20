package com.example.shifttesttask.data.storage

import com.example.shifttesttask.data.models.SaveUserDataModel

interface UserDataStorage {

    fun saveData(userData: SaveUserDataModel)
}