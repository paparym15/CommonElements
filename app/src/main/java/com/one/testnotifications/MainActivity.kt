package com.one.testnotifications

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setOneTimeWorkRequest()
        setPeriodicWorkRequest()

    }

    private fun setPeriodicWorkRequest() {
        val task =
            PeriodicWorkRequest.Builder(DownloadingWorker::class.java, 16, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(task)
    }

    private fun setOneTimeWorkRequest() {
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val data = Data.Builder()
            .putInt("KEY", 228)
            .build()
        val downloadingRequest = OneTimeWorkRequest.Builder(DownloadingWorker::class.java)
            .setConstraints(constraints)
            .setInputData(data)
            .build()
        val filteringRequest = OneTimeWorkRequest.Builder(FilteringWorker::class.java).build()
        val renderingRequest = OneTimeWorkRequest.Builder(RenderingWorker::class.java).build()
        val uploadingRequest = OneTimeWorkRequest.Builder(UploadingWorker::class.java).build()
        val workManager = WorkManager.getInstance(this)

        workManager
            .beginWith(downloadingRequest)
            .then(filteringRequest)
            .then(listOf(renderingRequest, uploadingRequest))
            .enqueue()
        workManager.getWorkInfoByIdLiveData(downloadingRequest.id).observe(this) {
            tv1.text = it.state.name
        }
    }
}