package com.example.ex06a_json_volley_jsonobject2_10130492;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView output;
    Button find;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.textthing);
        find = findViewById(R.id.button);

        find.setOnClickListener(v->{
            output.setText("讀取中，請稍候...");
            getData();
        });


    }
    private void parse(JSONObject json){
        try{
            JSONArray swim = json.getJSONArray("swim");
            JSONArray gym = json.getJSONArray("gym");

            String outputFormat = String.format("健身房：\r\n現在人數：%s人\r\n容留人數：%s人\r\n\r\n游泳池：\r\n現在人數：%s人\r\n容留人數：%s人",gym.getString(0),gym.getString(1),swim.getString(0),swim.getString(1));
            output.setText(outputFormat);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void getData(){
        Response.Listener<JSONObject> responseListener = response -> {
            parse(response);
        };
        Response.ErrorListener errorListener = err->{
            Log.d("JSONerr","error: "+ err.toString());
        };

        String url = "https://lkcsc.cyc.org.tw/api";
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(url,responseListener,errorListener);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}