package com.study.android.morden.java;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.study.android.databinding.ActivityRoomBinding;

public class RoomActivity extends AppCompatActivity {

    private ActivityRoomBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RoomViewModel viewModel = new ViewModelProvider(this).get(RoomViewModel.class);
        // UI 갱신
        viewModel.getAll().observe(this, todos -> {
            binding.result.setText(todos.toString());
        });

        // 버튼 클릭시 DB에 Insert
        binding.addButton.setOnClickListener(v -> {
            viewModel.insert(new Todo(binding.todoEdit.getText().toString()));
        });

    }

}