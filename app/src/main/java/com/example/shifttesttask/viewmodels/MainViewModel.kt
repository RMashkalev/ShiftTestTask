package com.example.shifttesttask.viewmodels

import androidx.lifecycle.ViewModel
import com.example.shifttesttask.domain.models.GreetingUserDataModel
import com.example.shifttesttask.domain.usecase.UserGreetingUseCase

class MainViewModel(private val userGreetingUseCase: UserGreetingUseCase) : ViewModel() {

    fun loadGreetingUserData() : GreetingUserDataModel {
        return userGreetingUseCase.execute()
    }
}