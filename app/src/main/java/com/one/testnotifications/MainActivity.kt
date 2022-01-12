package com.one.testnotifications

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
//            val intent = Intent(this, MyBackgroundService::class.java)
//            startService(intent)
//            bindService(intent, object : ServiceConnection {
//                override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//                    Log.d("-->", "service connected")
//                }
//
//                override fun onServiceDisconnected(name: ComponentName?) {
//                    Log.d("-->", "service disconnected")
//                }
//
//            }, BIND_AUTO_CREATE)
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(this, MyReceiver::class.java)
            val pendingIntent =
                PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 1000L,
                pendingIntent
            )
        }

    }
}