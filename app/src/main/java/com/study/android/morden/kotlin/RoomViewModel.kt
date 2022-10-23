package com.study.android.morden.kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var todos: LiveData<List<Todo>>
    private val db: AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "todo-db_kotlin").build()
    var newTodo: String? = null

    init {
        todos = getAll()
    }
    fun getAll(): LiveData<List<Todo>> {
        todos = db.todoDao().getAll()
        return todos
    }

    fun insert(todo: String) {
        viewModelScope.launch(Dispatchers.IO){
            db.todoDao().insert(Todo(todo))
        }
    }
}