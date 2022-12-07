package com.example.ex02a_activitylifecycle01a_10130492;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityMsg","SECONDACTIVITY onStop");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityMsg","SECONDACTIVITY onStart");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityMsg","SECONDACTIVITY onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityMsg","SECONDACTIVITY onPause");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityMsg","SECONDACTIVITY onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ActivityMsg","SECONDACTIVITY onRestart");
    }


}