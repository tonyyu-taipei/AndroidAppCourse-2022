package com.example.ex05_recyclerview01a_10130492;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button openBtn = this.findViewById(R.id.openBtn);

        View.OnClickListener obj =new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(in);
            }
        };
        openBtn.setOnClickListener(obj);
    }
}