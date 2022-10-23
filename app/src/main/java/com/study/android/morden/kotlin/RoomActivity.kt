package com.study.android.morden.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.study.android.databinding.ActivityRoomBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel:RoomViewModel = ViewModelProvider(this)[RoomViewModel::class.java]
        viewModel.getAll().observe(this, Observer { binding.result.text = it.toString() })

        binding.addButton.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                viewModel.insert(Todo(binding.todoEdit.text.toString()))
            }
        }
    }
}