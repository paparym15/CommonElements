package com.one.testnotifications.di

import com.one.testnotifications.presentation.MainActivity
import dagger.Component

@Component(modules = [DataModule::class, DomainModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}