package com.one.testnotifications.di.components

import android.app.Application
import android.content.Context
import com.one.testnotifications.MainActivity
import com.one.testnotifications.di.modules.RepositoryModule
import com.one.testnotifications.repositories.UserRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}