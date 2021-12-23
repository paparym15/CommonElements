package com.one.testnotifications

import android.app.Application
import com.one.testnotifications.di.components.ApplicationComponent
import com.one.testnotifications.di.components.DaggerApplicationComponent
import com.one.testnotifications.repositories.UserRepository
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

//class App: DaggerApplication() {
//
//    companion object {
//        lateinit var appComponent: ApplicationComponent
//    }
//
//    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
//
//        appComponent = DaggerApplicationComponent.builder().applicationContext(this).build()
//        return appComponent
//    }
//
//
//}

class App : Application() {

    val component by lazy {
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }
}