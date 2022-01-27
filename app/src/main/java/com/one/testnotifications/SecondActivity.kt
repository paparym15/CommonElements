package com.one.testnotifications

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.btn1
import kotlinx.android.synthetic.main.activity_second.btn2
import kotlinx.android.synthetic.main.activity_second.btn3
import kotlinx.android.synthetic.main.activity_second.btn4
import kotlinx.android.synthetic.main.activity_second.btn5

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        btn1.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        btn2.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
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

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("-->", "received")
    }
}