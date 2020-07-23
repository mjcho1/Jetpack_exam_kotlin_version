package com.example.room_exam_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "todo-db-kotlin"
    )
        .allowMainThreadQueries()
        .build()

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll();
    }

    fun insert(todo: Todo){
        db.todoDao().insert(todo)
    }
}