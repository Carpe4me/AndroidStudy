package com.study.android.morden.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.study.android.R
import com.study.android.databinding.ActivityRoomBinding

class RoomActivity: AppCompatActivity() {

//    private lateinit var binding: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityRoomBinding>(this, R.layout.activity_room)
        binding.lifecycleOwner = this

        val viewModel = ViewModelProvider(this)[RoomViewModel::class.java]
        binding.viewModel = viewModel
    }
}