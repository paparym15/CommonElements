package com.one.testnotifications

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

//        srl.setOnRefreshListener {
//            Toast.makeText(this, "Refreshed!", Toast.LENGTH_SHORT).show()
//        }
    }
}