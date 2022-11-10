package com.example.apptest1026_10130492;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity_10130492 extends AppCompatActivity implements MyListAdapter.OnItemClickListen {
    private Button menu1;
    int type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = this.getIntent().getExtras();
        type = bundle.getInt("type");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_10130492);
        menu1 = (Button) findViewById(R.id.menu1);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rc);
        MyListAdapter adapter = new MyListAdapter(getMyListData(), this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private MyListData[] getMyListData() {
        MyListData[] list = new MyListData[5];
        switch(type){
            case 0:
                list[0] = new MyListData("小籠包", R.drawable.longbao);
                list[1] = new MyListData("牛肉麵", R.drawable.beef);
                list[2] = new MyListData("臭豆腐", R.drawable.tofu);
                list[3] = new MyListData("蘿蔔糕", R.drawable.carrot);
                list[4] = new MyListData("珍珠奶茶", R.drawable.pearl);

                break;
            case 1:
               list[0] = new MyListData("拉麵",R.drawable.ramen);
               list[1] = new MyListData("炸豬排", R.drawable.pork);
               list[2] = new MyListData("壽司", R.drawable.sushi);
               list[3] = new MyListData("生魚片", R.drawable.sashi);
               list[4] = new MyListData("味噌湯", R.drawable.miso);

                break;
            case 2:
                list[0] = new MyListData("石鍋拌飯",R.drawable.krrice);
                list[1] = new MyListData("辛奇",R.drawable.kimchi);
                list[2] = new MyListData("辣炒年糕",R.drawable.kr3);
                list[3] = new MyListData("韓式烤肉",R.drawable.kr4);
                list[4] = new MyListData("松片",R.drawable.kr5);



        }
        return list;
    }
    public void backMain(){
        Intent intent = new Intent(this, MainActivity_10130492.class);
        startActivity(intent);
    }

    @Override
    public void OnItemClick(int position) {
    }
}