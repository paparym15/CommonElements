package com.one.testnotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.one.testnotifications.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private var listeners = mutableSetOf<(String) -> Unit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listeners.add(stringListener)

        binding.btn.setOnClickListener {
            listeners.forEach {
                it.invoke(binding.tv.text.toString())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        listeners.remove(stringListener)
    }

    private val stringListener: (String) -> Unit = {
        Toast.makeText(this, "string: $it", Toast.LENGTH_SHORT).show()
    }
}