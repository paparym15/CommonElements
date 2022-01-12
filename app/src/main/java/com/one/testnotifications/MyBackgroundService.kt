package com.one.testnotifications

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyBackgroundService: Service() {

    val binder = MyBinder()

    override fun onBind(intent: Intent?): IBinder? {
        Log.d("-->", "onBind")
        return binder
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("-->", "onCreate")
        stopSelf(5)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("-->", "onDestroy")
    }

    inner class MyBinder: Binder() {

        init {
            Log.d("-->", "MyBinder init block")
        }

        fun getService(): MyBackgroundService {
            return this@MyBackgroundService
        }
    }
}

