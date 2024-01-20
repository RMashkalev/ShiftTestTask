package com.example.shifttesttask.domain.usecase

import com.example.shifttesttask.domain.models.UserDataModel
import com.example.shifttesttask.domain.repository.UserDataRepository

class UserRegistrationUseCase(private val userDataRepository: UserDataRepository) {
    fun execute(userData: UserDataModel) {
        userDataRepository.saveData(userData = userData)
    }
}