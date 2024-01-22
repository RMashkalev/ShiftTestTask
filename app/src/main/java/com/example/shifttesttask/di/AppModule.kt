package com.example.shifttesttask.di

import com.example.shifttesttask.viewmodels.MainViewModel
import com.example.shifttesttask.viewmodels.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<RegistrationViewModel> {
        RegistrationViewModel(
            userRegistrationUseCase = get(),
            checkRememberUserDataUseCase = get()
        )
    }

    viewModel<MainViewModel> {
        MainViewModel(
            userGreetingUseCase = get(),
            clearRememberUserDataUseCase = get()
        )
    }
}