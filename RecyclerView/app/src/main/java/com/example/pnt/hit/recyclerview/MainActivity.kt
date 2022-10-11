package com.example.pnt.hit.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pnt.hit.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoList: MutableList<Todo>
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        setOnClickListener()
    }

    private fun init() {
        todoList = mutableListOf(
            Todo("123", false),
            Todo("124", true),
            Todo("125", false),
            Todo("126", false),
            Todo("127", true),
            Todo("128", false),
            Todo("129", true),
            Todo("120", false)
        )

        adapter = TodoAdapter(todoList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)
    }

    private fun setOnClickListener() {
        binding.btAdd.setOnClickListener {
            val title = binding.edTodo.text.toString()
            todoList.add(Todo(title, false))
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}