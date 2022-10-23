package com.study.android.morden.java;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.study.android.R;
import com.study.android.databinding.ActivityRoomJavaBinding;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRoomJavaBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_room_java);
        dataBinding.setLifecycleOwner(this);

        RoomViewModel viewModel = new ViewModelProvider(this).get(RoomViewModel.class);
        dataBinding.setViewModel(viewModel);
    }

}