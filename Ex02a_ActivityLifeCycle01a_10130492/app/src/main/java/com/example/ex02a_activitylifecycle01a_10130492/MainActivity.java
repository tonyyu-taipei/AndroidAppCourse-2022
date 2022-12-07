package com.example.ex02a_activitylifecycle01a_10130492;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button butt;
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityMsg","FIRSTACTIVITY onStop");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityMsg","FIRSTACTIVITY onStart");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityMsg","FIRSTACTIVITY onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityMsg","FIRSTACTIVITY onPause");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityMsg","FIRSTACTIVITY onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ActivityMsg","FIRSTACTIVITY onRestart");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butt = findViewById(R.id.butt);
        Intent intent = new Intent(this,SecondActivity.class);
        butt.setOnClickListener(l->{
            startActivity(intent);
        });

    }
}