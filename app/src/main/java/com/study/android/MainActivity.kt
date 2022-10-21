package com.study.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.study.android.databinding.ActivityMainBinding
import com.study.android.morden.java.RoomActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.roomJava.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    RoomActivity::class.java
                )
            )
        }
    }
}