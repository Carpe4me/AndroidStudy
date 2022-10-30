package com.study.android.ui.java.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.study.android.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private List<String> mData;
    private ArrayAdapter<String> mAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // 1. 데이터 준비
        initData();

        // 2. Adapter 준비
        initAdapter();

        // 3. ListView에 Adapter를 장착
        initListView();
    }

    private void initListView() {
        mListView = (ListView)findViewById(R.id.list_view);
        mListView.setAdapter(mAdapter);
    }

    private void initAdapter() {
        mAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, mData);
    }

    private void initData(){
        mData = new ArrayList<>();
        for(int i=0; i<=100; i++)
            mData.add("Item " + i);
    }
}