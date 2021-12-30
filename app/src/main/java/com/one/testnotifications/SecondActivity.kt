package com.one.testnotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_third.*
import kotlinx.android.synthetic.main.activity_third.swipeRefreshLayout

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        srl.setOnRefreshListener {
//            Toast.makeText(this, "Refreshed!", Toast.LENGTH_SHORT).show()
//        }
    }
}