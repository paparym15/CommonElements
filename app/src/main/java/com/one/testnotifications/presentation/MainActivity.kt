package com.one.testnotifications.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.one.testnotifications.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            viewModel.getUser()
        }

        btn2.setOnClickListener {
            viewModel.sendUser()
        }

        viewModel.userLD.observe(this) {
            tv1.text = it.firstName
            tv2.text = it.lastName
            tv3.text = it.age.toString()
        }

        viewModel.sendingStatus.observe(this) {
            tv4.text = if (it) "Sending worked!" else ""
        }

    }

}