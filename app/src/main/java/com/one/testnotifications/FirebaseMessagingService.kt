package com.one.testnotifications

import android.util.Log
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("TAG", "FCM Token: $token")

        val db = FirebaseDatabase.getInstance().getReference("token")
        db.setValue(token).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Token Saved", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        NotificationHelper.displayNotification(
            applicationContext,
            remoteMessage.notification?.title.toString(),
            remoteMessage.notification?.body.toString()
        )
        Log.d("FCM Message Id:", remoteMessage.messageId.toString())
        Log.d("FCM Notification Body:", remoteMessage.notification?.body.toString())
        Log.d("FCM Data Message:", remoteMessage.data.values.joinToString())
    }
}
