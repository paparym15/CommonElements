package com.one.testnotifications.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.one.testnotifications.R
import com.one.testnotifications.domain.usecases.GetUserUseCase
import com.one.testnotifications.domain.usecases.SendUserUseCase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val getUserUseCase by lazy { GetUserUseCase() }
    private val sendUserUseCase by lazy { SendUserUseCase() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            val user = getUserUseCase.execute()
            tv1.text = user.firstName
            tv2.text = user.lastName
            tv3.text = user.age.toString()
        }

        btn2.setOnClickListener {
            val result = sendUserUseCase.execute()
            if (result) tv4.text = "User sent!"
        }

    }

}