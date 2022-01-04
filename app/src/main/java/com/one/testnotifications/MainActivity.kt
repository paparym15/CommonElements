package com.one.testnotifications

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaPlayer = MediaPlayer(PlayerImpl(), DownloaderImpl())
        mediaPlayer.play()
        mediaPlayer.download()
            
        val student = Student()
        student.john = "adsasdasd"
        Log.d("-->", "${student.john}")

        student.johnAge = 17
        Log.d("-->", "${student.johnAge}")

        
    }
}

class Student() {
    var john: String? by StudentDelegate()
    var frank: String? by StudentDelegate()

    var johnAge by AgeDelegate()
}

class StudentDelegate{

    var formattedValue: String? = null

    operator fun setValue(
        thisRef: Any?,
        kProperty: KProperty<*>,
        value: String?
    ) {
        if (value != null && value.length > 5) {
            formattedValue = value.uppercase()
        }
    }

    operator fun getValue(
        thisRef: Any?, property: KProperty<*>
    ): String? {
       return formattedValue
    }
}

class AgeDelegate: ReadWriteProperty<Student, Int> {

    private var age = 0

    override fun getValue(thisRef: Student, property: KProperty<*>): Int = age

    override fun setValue(thisRef: Student, property: KProperty<*>, value: Int) {
        age = if (value < 18) 0 else value
    }

}