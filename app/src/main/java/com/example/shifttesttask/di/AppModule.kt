package com.example.shifttesttask.di

import com.example.shifttesttask.presentation.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<RegistrationViewModel> {
        RegistrationViewModel(
            userRegistrationUseCase = get()
        )
    }
}