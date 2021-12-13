package com.one.testnotifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@FlowPreview
class MainViewModel : ViewModel() {


    init {
//        testingFlowConcat()
        testConflate()
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
}