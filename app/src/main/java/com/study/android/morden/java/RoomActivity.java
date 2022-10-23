package com.study.android.morden.java;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.study.android.R;
import com.study.android.databinding.ActivityRoomBinding;

public class RoomActivity extends AppCompatActivity {

    private ActivityRoomBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //viewBinding = ActivityRoomBinding.inflate(getLayoutInflater());
        ActivityRoomBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_room);
        dataBinding.setLifecycleOwner(this);

        RoomViewModel viewModel = new ViewModelProvider(this).get(RoomViewModel.class);
        dataBinding.setViewModel(viewModel);
    }

}