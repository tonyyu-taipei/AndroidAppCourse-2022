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
            JSONArray simpleInfo = json.getJSONObject("XML_Head").getJSONObject("Infos").getJSONArray("Info");
            JSONObject num0 = simpleInfo.getJSONObject(0);



            String outputFormat = String.format("景點：\r%s\r\n景點介紹：\r%s",num0.getString("Name"),num0.getString("Toldescribe"));
            output.setText(outputFormat);
        }catch(Exception e){
            e.printStackTrace();
            Log.e("JSON ERR",e.toString());
        }
    }

    private void getData(){
        Log.d("JSON","Loading JSON Files");
        Response.Listener<JSONObject> responseListener = response -> {
            parse(response);
        };
        Response.ErrorListener errorListener = err->{
            Log.d("JSONerr","error: "+ err.toString());
        };

        String url = "https://gis.taiwan.net.tw/XMLReleaseALL_public/scenic_spot_C_f.json";
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(url,responseListener,errorListener);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}