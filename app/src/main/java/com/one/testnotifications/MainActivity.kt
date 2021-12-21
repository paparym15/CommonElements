package com.one.testnotifications

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.kotlin.zipWith
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.RuntimeException
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        zipWithJavaExample()
//        zipWithKotlinExample()
//        scanExample()
//        ambExample()
//        mergeExample()
//        startsWithExample()
//        concatExample()
//        combineLatestExample()
//        mergeDelayErrorExample()
//        switchOnExample()
        conditionalObservables()
    }

    private fun scanExample() {
        Observable.just(1, 2)
            .subscribeOn(Schedulers.io())
            .scan { t1, t2 ->
                println("printed in scan: ${Thread.currentThread().name}")
                t1 + t2
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                println("printed: $result")
                println("printed in subscribe: ${Thread.currentThread().name}")
            }
    }

    private fun creationExamples() {

    }

    // COMBINATION examples
    private fun zipWithJavaExample() {
        val names = Observable.just("John", "Frank", "Ruby")
        val age = Observable.just("26", "23")

        names.zipWith(age, { t1, t2 ->
            "$t1 $t2"
        })
            .subscribe {
                println("printed: $it")
            }
    }

    private fun zipWithKotlinExample() {
        val names = Observable.just("John", "Frank", "Ruby")
        val age = Observable.just("26", "23").delay(2000, TimeUnit.MILLISECONDS)

        names.zipWith(age)
            .map {
                "${it.first} ${it.second}"
            }
            .subscribe {
                println("printed: $it")
            }
    }

    private fun mergeExample() {
        val first = Single.just(1)
        val second = Single.just(2).delay(1000, TimeUnit.MILLISECONDS)
        val third = Single.just(3)
        first.mergeWith(second).mergeWith(third)
            .subscribe {
                println("printed: $it")
            }
    }

    private fun startsWithExample() {
        Observable.create<Int> {
            it.onNext(6)
        }.startWith(Single.just(1))
            .subscribe {
                println("printed: $it")
            }
    }

    private fun concatExample() {
        val first = Observable.just(1, 2, 3)
        val second = Observable.just(4, 5, 6).delay(2000, TimeUnit.MILLISECONDS)
        val third = Observable.just(7, 8, 9)
        first.concatWith(second).concatWith(third)
            .subscribe {
                println("printed: $it")
            }
    }

    // TODO
    private fun combineLatestExample() {
        val pricesForIds = Observable.create<String> {
            it.onNext("first")
            Thread.sleep(1000)
            it.onNext("second")
            Thread.sleep(1000)
            it.onNext("third")
        }
        val itemIds = Observable.create<Int> {
            it.onNext(1)
            Thread.sleep(1000)
            it.onNext(2)
            Thread.sleep(5000)
            it.onNext(3)
        }

        Observable.combineLatest<Int, String, Pair<Int, String>>(
            itemIds,
            pricesForIds, { t1, t2 ->
                Pair(t1, t2)
            })
            .map {
                "${it.first} is the same as ${it.second}"
            }
            .subscribe {
                println("printed: $it")
            }

    }

    private fun ambExample() {
        val itemIds = Observable.just(1, 2, 3)
            .delay(100, TimeUnit.MILLISECONDS)

        val pricesForIds = Observable.just(10, 20, 30)
        itemIds.ambWith(pricesForIds).subscribe {
            println("printed: $it")
        }
    }

    private fun mergeDelayErrorExample() {
        val first = Single.error<Int> { RuntimeException("oops") }
        val second = Single.just(1)
        val third = Single.just(2)

        Single.mergeDelayError(
            first,
            second,
            third
        ).subscribe {
            println("printed: $it")
        }
    }

    private fun switchOnExample() {
        val database = Observable.interval(100, TimeUnit.MILLISECONDS).doOnNext {
            println("printed: $it from local database")
        }
        val network = Observable.just(4, 5, 6).delay(200, TimeUnit.MILLISECONDS)

        Observable.switchOnNext(database.map { network }).subscribe { println("printed: $it") }
    }

    private fun conditionalObservables() {

        Observable.interval(200, TimeUnit.MILLISECONDS).timeout(1000L, TimeUnit.MILLISECONDS)
            .subscribe {
                println("printed: $it")
            }
    }

}