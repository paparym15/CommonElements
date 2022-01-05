package com.one.testnotifications

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper.cancel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.Exception

@FlowPreview
class MainViewModel : ViewModel() {

    val testScope = CoroutineScope(Dispatchers.IO)

    init {
//        cancellableEg()
//        debugCoroutine()

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

    private fun flowLaunchIn() {

        (1..5).asFlow()
            .onEach {
                delay(100)
                Log.d("-->", "$it")
            }

    }

    private fun flowLaunchIn2() {
        (6..10).asFlow()
            .onEach { Log.d("-->", "$it") }
            .launchIn(viewModelScope)
    }

    private fun testingDownstream() {

        (1..5).asFlow()
            .onEach { Log.d("-->", "first: $it on ${Thread.currentThread()}") }
            .flowOn(Dispatchers.IO)
            .onEach { Log.d("-->", "second: $it on ${Thread.currentThread()}") }
            .onStart { Log.d("-->", "start on ${Thread.currentThread()}") }
            .flowOn(Dispatchers.Main)
            .onEach { Log.d("-->", "third: $it on ${Thread.currentThread()}") }
            .onCompletion { Log.d("-->", "completed") }
            .launchIn(testScope)

    }

    private fun flatMap() {
        val numbers = (1..3).asFlow().onEach { delay(80) }

        numbers.flatMapLatest {
            flowOf("$it: one", "$it: two", "$it: three").onEach { delay(100) }
        }
            .onEach {
                Log.d("-->", it)
            }.launchIn(viewModelScope)
    }

    private fun emitStrings(i: Int): Flow<String> =
        flow {
            emit("$i one")
            delay(500)
            emit("$i two")
            delay(500)
            emit("$i three")
        }

    private fun exceptions() =
        flow {
            for (i in 1..3) {
                Log.d("-->", "Emitting $i")
                check(i <= 1)
                emit(i)
            }
        }

    private fun onCompletionEg() {
        viewModelScope.launch {
            exceptions()
                .onCompletion { cause ->
                    if (cause != null) Log.d("-->", "there was an error")
                }
                .catch { Log.d("-->", "caught: $it") }
                .collect { Log.d("-->", "collected $it") }
        }
    }

    private fun cancellableEg() {
        viewModelScope.launch {
            (1..3).asFlow()
                .onEach {
                    Log.d("-->", "onEach $it")
                    check(it <= 2)
                }
                .onCompletion { Log.d("-->", "onCompletion") }
                .catch { Log.d("-->", "got an error $it") }
                .cancellable()
                .collect {
                    Log.d("-->", "collected $it")
                    if (it <= 2) cancel()
                }
        }

    }

    private fun debugCoroutine() {
        val ceh = CoroutineExceptionHandler { _, throwable ->
            Log.d("-->", "caught: ${throwable.message}")
        }
        viewModelScope.launch(ceh) {
            Log.d("-->", "started")

            val a = async {
                delay(5000)
                5
            }

            Log.d("-->", "firstValue result: ${a.await()}")


            val b = async {
                delay(2000)
                11
            }

            Log.d("-->", "secondValue result: ${b.await()}")


            Log.d("-->", "result: ${a.await() + b.await()}")
        }
    }

    inline fun both(
         crossinline first: (() -> Unit) -> Unit,
         crossinline second: (() -> Unit) -> Unit
    ) {
        first { first { Log.d("-->", "inside of both first") } }
        second { second { Log.d("-->", "inside of both second") } }
    }

    fun second(inner: () -> Unit) {
        Log.d("-->", "second started")
        inner()
        Log.d("-->", "second ended")
    }

     fun first(inner: () -> Unit) {
        Log.d("-->", "first started")
        inner()
        Log.d("-->", "first ended")
    }
}