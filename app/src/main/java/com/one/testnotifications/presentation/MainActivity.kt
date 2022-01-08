package com.one.testnotifications.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.one.testnotifications.R
import com.one.testnotifications.app.App
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).appComponent.inject(this)

        Log.d("-->", "activity created")

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