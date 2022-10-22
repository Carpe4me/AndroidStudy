package com.study.android.morden.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.study.android.databinding.ActivityRoomBinding

class RoomActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db: AppDatabase = Room.databaseBuilder(this, AppDatabase::class.java, "todo-db_kotlin")
            .allowMainThreadQueries()
            .build()

        binding.result.text = db.todoDao().getAll().toString()
        binding.addButton.setOnClickListener {
            db.todoDao().insert(Todo(binding.result.text.toString()))
            binding.result.text = db.todoDao().getAll().toString()
        }
    }
}