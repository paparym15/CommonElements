package com.one.testnotifications.app

import android.app.Application
import com.one.testnotifications.di.AppComponent
import com.one.testnotifications.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}