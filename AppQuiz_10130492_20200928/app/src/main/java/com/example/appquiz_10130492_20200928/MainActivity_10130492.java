package com.example.appquiz_10130492_20200928;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity_10130492 extends AppCompatActivity implements View.OnClickListener{
    int count = 0;
    TextView txt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10130492);
        txt = findViewById(R.id.counter);
    }

    @Override
    public void onClick(View view) {
        count++;
        txt.setText(count+"");
    }
    public void resetCnt(View view){
        count = 0;
        txt.setText(count+"");
    }
}