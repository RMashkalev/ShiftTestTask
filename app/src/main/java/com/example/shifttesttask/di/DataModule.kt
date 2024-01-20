package com.example.shifttesttask.di

import com.example.shifttesttask.data.repository.UserDataRepositoryImplementation
import com.example.shifttesttask.data.storage.SharedPrefStorage
import com.example.shifttesttask.data.storage.UserDataStorage
import com.example.shifttesttask.domain.repository.UserDataRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserDataRepository> {
        UserDataRepositoryImplementation(userDataStorage = get())
    }

    single<UserDataStorage> {
        SharedPrefStorage(context = get())
    }
}