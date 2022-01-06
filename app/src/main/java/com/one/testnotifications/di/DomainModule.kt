package com.one.testnotifications.di

import com.one.testnotifications.domain.usecases.GetUserUseCase
import com.one.testnotifications.domain.usecases.SendUserUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { GetUserUseCase(get()) }
    factory { SendUserUseCase(get()) }
}