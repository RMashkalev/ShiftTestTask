package com.example.shifttesttask.domain.usecase

import com.example.shifttesttask.domain.models.GreetingUserDataModel
import com.example.shifttesttask.domain.repository.UserDataRepository

class UserGreetingUseCase(private val userDataRepository: UserDataRepository) {

    fun execute() : GreetingUserDataModel {
        return userDataRepository.loadGreetingData()
    }
}