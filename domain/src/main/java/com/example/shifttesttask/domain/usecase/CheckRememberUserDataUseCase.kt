package com.example.shifttesttask.domain.usecase

import com.example.shifttesttask.domain.repository.UserDataRepository

class CheckRememberUserDataUseCase(private val userDataRepository: UserDataRepository) {
    fun execute(): Boolean {
        return userDataRepository.checkRememberData()
    }
}