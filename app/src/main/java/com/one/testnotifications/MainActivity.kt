package com.one.testnotifications

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.one.testnotifications.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var usersAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usersAdapter = UsersAdapter()

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = usersAdapter
        }

        UsersService.addListener(usersListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        UsersService.removeListener(usersListener)
    }

    private val usersListener: UsersListener = {
        usersAdapter.users = it
    }
}