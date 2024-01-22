package com.example.shifttesttask.di

import com.example.shifttesttask.domain.usecase.UserGreetingUseCase
import com.example.shifttesttask.domain.usecase.UserRegistrationUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<UserRegistrationUseCase> {
        UserRegistrationUseCase(userDataRepository = get())
    }

    factory<UserGreetingUseCase> {
        UserGreetingUseCase(userDataRepository = get())
    }
}