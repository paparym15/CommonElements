package com.one.testnotifications

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.one.testnotifications.di.components.ApplicationComponent
import com.one.testnotifications.repositories.UserRepository
import dagger.android.DaggerApplication
import dagger.android.DaggerApplication_MembersInjector
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import java.util.*
import javax.inject.Inject
import kotlin.ArithmeticException
import kotlin.AssertionError
import kotlin.collections.HashMap
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).component.inject(this)


        val producer = flowOf(1, 2, 3, 4, 5)

        lifecycleScope.launch {
            val time = measureTimeMillis {
                producer.conflate().collect {
                    delay(300)
                    println("printed: $it")
                }
            }
            println("printed: $time")
        }

    }
}