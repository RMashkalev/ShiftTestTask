package com.example.shifttesttask.presentation

import androidx.lifecycle.ViewModel
import com.example.shifttesttask.domain.models.UserDataModel
import com.example.shifttesttask.domain.usecase.UserRegistrationUseCase

class RegistrationViewModel(
    private val userRegistrationUseCase: UserRegistrationUseCase
): ViewModel() {

    fun saveUserData(userData: UserDataModel) {
        userRegistrationUseCase.execute(userData)
    }
}