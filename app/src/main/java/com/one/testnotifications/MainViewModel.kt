package com.one.testnotifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@FlowPreview
class MainViewModel : ViewModel() {


    init {
//        testingFlowConcat()
//        testConflate()

        rxDataSource()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Thread.sleep(4000)
                println("printed: $it")
            }
    }

    private fun testingFlowConcat() {
        val flow1 = (1..5).asFlow()

        viewModelScope.launch {
           flow1.flatMapConcat { integer ->
                flow {
                    emit(integer + integer)
                }
            }.onEach {
                println("printed: $it")
            }
        }
    }

    private fun testConflate() {
        val flow1 = flow {
            for (i in 1..100) {
                emit(i)
                delay(100)
            }
        }
        viewModelScope.launch {
            flow1
                .buffer()
                .collect {
                delay(5000L)
                println("printed: $it")
            }
        }
    }

    fun rxDataSource() = Observable.create<Int>() { subscriber ->
            for (i in 0..100) {
                Thread.sleep(3000)
                subscriber.onNext(i)
            }
        }

}