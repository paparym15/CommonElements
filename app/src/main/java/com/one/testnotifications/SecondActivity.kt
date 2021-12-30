package com.one.testnotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    private val listener = Listener()

    override fun onStart() {
        super.onStart()
        SingletonObject.register(listener)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private inner class Listener : GlobalSingletonListener {

        override fun onEvent() {
            println("printed: onEvent")
        }

    }
}