package com.example.shifttesttask.viewmodels

import androidx.lifecycle.ViewModel
import com.example.shifttesttask.domain.models.GreetingUserDataModel
import com.example.shifttesttask.domain.usecase.ClearRememberUserDataUseCase
import com.example.shifttesttask.domain.usecase.UserGreetingUseCase

class MainViewModel(
    private val userGreetingUseCase: UserGreetingUseCase,
    private val clearRememberUserDataUseCase: ClearRememberUserDataUseCase
) : ViewModel() {

    fun loadGreetingUserData(): GreetingUserDataModel {
        return userGreetingUseCase.execute()
    }

    fun clearRememberUserData() {
        return clearRememberUserDataUseCase.execute()
    }
}