package com.example.ex05_recyclerview01c_onitemclicked01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements MyListAdapter.OnItemClickListen, View.OnClickListener{
    ArrayList<MyListData> mList = null;
    MyListAdapter adapter = null;
    Button insert, del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mList = getMyArrayListData();
        adapter = new MyListAdapter(mList, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        insert = findViewById(R.id.ins);
        del = findViewById(R.id.del);

        insert.setOnClickListener(this);
        del.setOnClickListener(this);

    }

    public ArrayList<MyListData> getMyArrayListData(){
        ArrayList<MyListData> mList = new ArrayList<>();
        mList.add(new MyListData("Delete", android.R.drawable.ic_delete));
        mList.add(new MyListData("Email", android.R.drawable.ic_dialog_email));
        mList.add(new MyListData("Info", android.R.drawable.ic_dialog_info));
        mList.add(new MyListData("Dialer", android.R.drawable.ic_dialog_dialer));
        mList.add(new MyListData("Alert", android.R.drawable.ic_dialog_alert));
        mList.add(new MyListData("Map", android.R.drawable.ic_dialog_map));
        return mList;
    }

    public void insertItem(View view){
        int min = 0;

        int max = mList.size()-1;
        Random random = new Random();
        int index = random.nextInt((max-min)+1)+min;
        MyListData newItem = new MyListData("new Item"+index, android.R.drawable.ic_dialog_map);
        mList.add(index, newItem);
        adapter.notifyItemInserted(index);
    }

    public void deleteItem(View view){
        int min = 0;
        int max = mList.size()-1;
        if(mList.size() == 1){
            Toast.makeText(this,"不能再刪了！",Toast.LENGTH_LONG).show();
            return;
        }
        Random random = new Random();
        int index = random.nextInt((max-min)+1)+min;
        mList.remove(index);
        adapter.notifyItemRemoved(index);
    }

    @Override
    public void OnItemClick(int position) {
        MyListData item = mList.get(position);
        item.setDescription("Clicked");
        adapter.notifyItemChanged(position);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch(id){
            case R.id.ins:
                insertItem(view);
                break;
            case R.id.del:
                deleteItem(view);
                break;
        }
    }
}