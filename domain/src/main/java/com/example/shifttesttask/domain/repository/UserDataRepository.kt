package com.example.shifttesttask.domain.repository

import com.example.shifttesttask.domain.models.UserDataModel

interface UserDataRepository {
    fun saveData(userData: UserDataModel)
}