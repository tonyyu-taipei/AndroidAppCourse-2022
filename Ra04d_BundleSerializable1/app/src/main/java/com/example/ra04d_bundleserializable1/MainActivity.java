package com.example.ra04d_bundleserializable1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private void findViews(){
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                et = (EditText)findViewById(R.id.editText);
                Editable etData = et.getText();
                String data = etData.toString();

                Bundle bundle = new Bundle();
                InfoObject info = new InfoObject();
                info.data = data;
                bundle.putSerializable("infoObj", info);
                bundle.putString("Name",btn.getText().toString());
                intent.putExtras(bundle);

                intent.setClass(MainActivity.this,SecondActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}