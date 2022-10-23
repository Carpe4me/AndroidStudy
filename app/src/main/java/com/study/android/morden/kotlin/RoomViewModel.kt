package com.study.android.morden.kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomViewModel(application: Application) : AndroidViewModel(application) {
    private val db: AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "todo-db_kotlin").build()

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    suspend fun insert(todo: Todo) {
        db.todoDao().insert(todo)
    }
}