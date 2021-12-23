package com.one.testnotifications.di.components

import android.content.Context
import com.one.testnotifications.di.modules.RepositoryModule
import com.one.testnotifications.repositories.UserRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class])
interface ApplicationComponent {

    fun repository(): UserRepository

    @Component.Builder
    interface Builder {
        @BindsInstance fun applicationContext(applicationContext: Context): Builder

        fun build(): ApplicationComponent
    }
}