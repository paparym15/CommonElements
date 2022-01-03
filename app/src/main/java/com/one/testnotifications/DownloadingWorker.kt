package com.one.testnotifications

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class DownloadingWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            for (i in 1..10) {
                Log.d("-->", "Downloading $i + ${Thread.currentThread()}")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}