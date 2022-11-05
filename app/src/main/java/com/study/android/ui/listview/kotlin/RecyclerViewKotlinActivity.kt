package com.study.android.ui.listview.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.study.android.R
import com.study.android.databinding.ActivityRecyclerViewKotlinBinding

class RecyclerViewKotlinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewKotlinBinding

    private val todos = listOf(
        Todo("make bootcamp #1", false),
        Todo("make bootcamp #2", false),
        Todo("make bootcamp #3", false),
        Todo("make bootcamp #4", false),
        Todo("make bootcamp #5", false),
        Todo("make bootcamp #6", false),
        Todo("make bootcamp #7", false),
        Todo("make bootcamp #8", false),
        Todo("make bootcamp #9", false),
        Todo("make bootcamp #10", false),
        Todo("make bootcamp #2", false),
        Todo("make bootcamp #3", false),
        Todo("make bootcamp #1", false),
        Todo("make bootcamp #2", false),
        Todo("make bootcamp #3", false),
        Todo("make bootcamp #1", false),
        Todo("make bootcamp #2", false),
        Todo("make bootcamp #3", false),
        Todo("make bootcamp #4", false),
        Todo("make bootcamp #5", false),
        Todo("make bootcamp #6", false),
        Todo("make bootcamp #7", false),
        Todo("make bootcamp #8", false),
        Todo("make bootcamp #9", false),
        Todo("make bootcamp #10", false)

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeViews()
    }

    private fun initializeViews() {
        binding.recyclerTodoList.layoutManager = LinearLayoutManager(this)
        binding.recyclerTodoList.adapter = TodoAdapter(todos)

        binding.recyclerTodoList.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(!binding.recyclerTodoList.canScrollVertically(1)
                    && newState == RecyclerView.SCROLL_STATE_IDLE){
                    Toast.makeText(recyclerView.context, "last item ", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.clearButton.setOnClickListener {
            (binding.recyclerTodoList.adapter as? TodoAdapter)?.clearAll()
        }
    }
}