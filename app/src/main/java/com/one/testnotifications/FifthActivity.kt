package com.one.testnotifications

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)


        btn1.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        btn2.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            startActivity(i)
        }

        btn3.setOnClickListener {
            val i = Intent(this, ThirdActivity::class.java)
            startActivity(i)
        }
        btn4.setOnClickListener {
            val i = Intent(this, FourthActivity::class.java)
            startActivity(i)
        }
        btn5.setOnClickListener {
            val i = Intent(this, FifthActivity::class.java)
            startActivity(i)
        }
    }
}