package com.example.ex01_button02_onclick01_10130492;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    Button btn2, btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.textView);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
    }

    public void onClick1(View view) {
        textview.setText("This is button1");
        btn2.setText("Press Me");
        btn1.setText("BTN1");

    }
    public void onClick2(View view){
        textview.setText("This is button2");
        btn1.setText("Press Me");
        btn2.setText("BTN2");


    }

}