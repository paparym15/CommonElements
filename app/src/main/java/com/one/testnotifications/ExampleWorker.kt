package com.one.testnotifications

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class ExampleWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            for (i in 1..10) {
                Log.d("-->", "$i")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}