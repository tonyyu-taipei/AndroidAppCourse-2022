package com.example.ex02_button02_onclick03_10130492;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView text;
    Button btn, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        btn2 = findViewById(R.id.button2);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String output="";
        switch(id){
            case R.id.button:
                output = "Button1 is clicked";
                break;
            case R.id.button2:
                output = "Button2 is clicked";
                break;

        }
        text.setText(output);
    }
}