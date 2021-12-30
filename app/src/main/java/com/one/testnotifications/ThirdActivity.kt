package com.one.testnotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        swipeRefreshLayout.setOnRefreshListener {
            Toast.makeText(this, "Refreshed!", Toast.LENGTH_SHORT).show()
        }
    }
}