package com.example.ra08d_recycleview_readfromassets_json01_10130492;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rec = (RecyclerView) findViewById(R.id.rec);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rec.setLayoutManager(linearLayoutManager);

        JsonLoad js = new JsonLoad(loadJSONFromAsset());
        ArrayList<String>[] userData = js.load();

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, userData);
        rec.setAdapter(customAdapter);

    }




    public String loadJSONFromAsset(){
        String json = null;
        try{
            InputStream is = getAssets().open("users_list.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        }catch(IOException e){
            e.printStackTrace();
        }

        return json;
    }
}