package com.example.shifttesttask.data.repository

import com.example.shifttesttask.data.models.SaveUserDataModel
import com.example.shifttesttask.data.storage.UserDataStorage
import com.example.shifttesttask.domain.models.GreetingUserDataModel
import com.example.shifttesttask.domain.models.UserDataModel
import com.example.shifttesttask.domain.repository.UserDataRepository

class UserDataRepositoryImplementation(
    private val userDataStorage: UserDataStorage
) : UserDataRepository {
    override fun saveData(userData: UserDataModel) {
        val saveUserData = SaveUserDataModel(
            userName = userData.userName,
            userSurname = userData.userSurname,
            userPassword = userData.userPassword)
        userDataStorage.saveData(saveUserData)
    }

    override fun loadGreetingData(): GreetingUserDataModel {
        return userDataStorage.loadGreetingData()
    }

}