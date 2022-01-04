package com.one.testnotifications

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class ExampleJobService : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        for (i in 1..10) {
            Thread.sleep(1000)
            Log.d("-->", "work is running $i")
        }
        jobFinished(params, false)
        return true

    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("-->", "job cancelled before")
        return false
    }

}