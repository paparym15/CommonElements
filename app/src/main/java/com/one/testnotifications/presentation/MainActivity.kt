package com.one.testnotifications.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.one.testnotifications.R
import com.one.testnotifications.data.datasource.local.UserLocalDataSourceImpl
import com.one.testnotifications.data.datasource.remote.UserRemoteDataSourceImpl
import com.one.testnotifications.data.repository.UserRepositoryImpl
import com.one.testnotifications.domain.usecases.GetUserUseCase
import com.one.testnotifications.domain.usecases.SendUserUseCase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var vmFactory: MainViewModelFactory
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this, vmFactory).get(
            MainViewModel::class.java
        )

        vm.resultLD.observe(this) {
            if (it) tv4.text = "User sent!"
        }
        vm.userLD.observe(this) {
            tv1.text = it.firstName
            tv2.text = it.lastName
            tv3.text = it.age.toString()
        }

        btn1.setOnClickListener {
            vm.getData()

        }

        btn2.setOnClickListener {
            vm.sendData()
        }

    }

}