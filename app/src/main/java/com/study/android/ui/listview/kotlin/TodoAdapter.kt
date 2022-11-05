package com.study.android.ui.listview.kotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.study.android.databinding.RecyclerItemTodoBinding

class TodoAdapter(private val todos: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    fun clearAll(){
        todos.forEach { it.completed = true }
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        Log.d("TEST", "onCreateViewHolder")
        val binding = RecyclerItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return TodoViewHolder(binding).also { holder ->
            binding.completedCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
                todos.getOrNull(holder.absoluteAdapterPosition)?.completed = isChecked
            }
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        Log.d("TEST", "onBindViewHolder")
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int = todos.size


    class TodoViewHolder(private val binding: RecyclerItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo){
            binding.todoTitleText.text = todo.title
            binding.completedCheckBox.isChecked = todo.completed
        }
    }
}