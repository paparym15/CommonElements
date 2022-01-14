package com.one.testnotifications

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("-->", "ACTIVITY onCreate()")

//        frame.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame, MainFragment())
                .addToBackStack(null)
                .commit()
//        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("-->", "ACTIVITY onStart()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("-->", "ACTIVITY onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("-->", "ACTIVITY onResume()")

        val cursor: Cursor? = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        while (cursor?.moveToNext() == true) {

        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("-->", "ACTIVITY onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("-->", "ACTIVITY onDestroy()")
    }
}