package com.study.android.morden.java;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.study.android.databinding.ActivityRoomBinding;

public class RoomActivity extends AppCompatActivity {

    private ActivityRoomBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "todo-db_java")
                .build();

        // UI 갱신
        db.todoDao().getAll().observe(this, todos -> {
            binding.result.setText(todos.toString());
        });

        // 버튼 클릭시 DB에 Insert
        binding.addButton.setOnClickListener(v -> {
            new InsertAyncTask(db.todoDao())
                    .execute(new Todo(binding.result.getText().toString()));
        });

    }

    private static class InsertAyncTask extends AsyncTask<Todo, Void, Void>{
        private TodoDao mTodoDao;

        public InsertAyncTask(TodoDao mTodoDao) {
            this.mTodoDao = mTodoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            mTodoDao.insert(todos[0]);
            return null;
        }
    }
}