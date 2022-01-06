package com.one.testnotifications.app

import android.app.Application
import com.one.testnotifications.di.appModule
import com.one.testnotifications.di.dataModule
import com.one.testnotifications.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}