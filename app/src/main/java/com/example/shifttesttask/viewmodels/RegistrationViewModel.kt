package com.example.shifttesttask.viewmodels

import androidx.lifecycle.ViewModel
import com.example.shifttesttask.domain.models.UserDataModel
import com.example.shifttesttask.domain.usecase.CheckRememberUserDataUseCase
import com.example.shifttesttask.domain.usecase.UserRegistrationUseCase

class RegistrationViewModel(
    private val userRegistrationUseCase: UserRegistrationUseCase,
    private val checkRememberUserDataUseCase: CheckRememberUserDataUseCase
): ViewModel() {

    fun saveUserData(userData: UserDataModel) {
        userRegistrationUseCase.execute(userData)
    }

    fun checkRememberUserData() : Boolean {
        return checkRememberUserDataUseCase.execute()
    }
}