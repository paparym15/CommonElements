package com.one.testnotifications

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class RenderingWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            for (i in 1..3000) {
                Log.d("-->", "Redering $i")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}