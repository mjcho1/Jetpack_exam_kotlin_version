package com.example.room_exam_kotlin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this,
                AndroidViewModelFactory(application)).get(MainViewModel::class.java)

        mainViewModel.getAll().observe(this, Observer { todos ->
            result_text.text = todos.toString()
        })

        add_button.setOnClickListener {
            mainViewModel.insert(Todo(todo_edit.text.toString()))
        }
    }
}