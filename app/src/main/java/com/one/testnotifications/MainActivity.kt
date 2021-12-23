package com.one.testnotifications

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.one.testnotifications.repositories.UserRepository
import dagger.android.DaggerApplication
import dagger.android.DaggerApplication_MembersInjector
import java.util.*
import javax.inject.Inject
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    @Inject lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userRepository.callAndStore()
    }
}