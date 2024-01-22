package com.example.shifttesttask.domain.usecase

import com.example.shifttesttask.domain.repository.UserDataRepository

class ClearRememberUserDataUseCase(private val userDataRepository: UserDataRepository) {
    fun execute() {
        userDataRepository.clearRememberUserData()
    }
}