package com.one.testnotifications

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val JOB_SCHEDULER_ID = 123
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val message = handler.obtainMessage(2)
//        handler.sendMessage(message)


        btn1.setOnClickListener {
            scheduleJob()
        }

        btn2.setOnClickListener {
            cancelJob()
        }
    }

    private fun scheduleJob() {
        val componentName = ComponentName(this, ExampleJobService::class.java)
        val jobInfo = JobInfo.Builder(JOB_SCHEDULER_ID, componentName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            .setPersisted(true)
            .setPeriodic(15 * 60 * 1000)
            .build()

        val jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
        val resultCode = jobScheduler.schedule(jobInfo)
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.d("-->", "job scheduled")
        } else {
            Log.d("-->", "job failed")
        }
    }

    private fun cancelJob() {
        val jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.cancel(JOB_SCHEDULER_ID)
    }

    private val handler = Handler(Looper.getMainLooper()) {
        when (it.what) {
            1 -> {
                Log.d("-->", "1 $it")
            }
            2 -> {
                Log.d("-->", "2 $it")
            }
        }
        return@Handler true
    }

}