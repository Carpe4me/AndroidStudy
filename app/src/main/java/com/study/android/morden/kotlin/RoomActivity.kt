package com.study.android.morden.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.study.android.R
import com.study.android.databinding.ActivityRoomBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(this, AppDatabase::class.java, "todo-db_kotlin")
            .build()


        db.todoDao().getAll().observe(this, Observer { binding.result.text = it.toString() })

        binding.addButton.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                db.todoDao().insert(Todo(binding.todoEdit.text.toString()))
            }
        }
    }
}