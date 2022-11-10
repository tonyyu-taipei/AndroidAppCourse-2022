package com.example.apptest1026_10130492;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_10130492 extends AppCompatActivity {
    private Button buttonTw;
    private Button buttonJp;
    private Button buttonKr;
    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_10130492);
        buttonTw = findViewById(R.id.tw);
        buttonJp = findViewById(R.id.jp);
        buttonKr = findViewById(R.id.kr);

        buttonTw.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                bundle.putInt("type",0);


                openSecondActivity();
            }
        });
        buttonJp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                bundle.putInt("type",1);


                openSecondActivity();
            }
        });
        buttonKr.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                bundle.putInt("type",2);

                openSecondActivity();
            }
        });
    }
    public void openSecondActivity(){
        Intent intent = new Intent(this, SecondActivity_10130492.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}