package com.study.android.ui.java.listview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.android.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private ArrayList<MainData> arrayList;
    private RecyclerView recyclerView;
    private RecyclerAdapter mainAdapter;
    private LinearLayoutManager linearLayoutManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();
        mainAdapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);

        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainData mainData = new MainData(R.mipmap.ic_launcher,
                        "홍드로이드", "리사이클뷰");
                arrayList.add(mainData);
                mainAdapter.notifyDataSetChanged();

            }
        });
    }
}