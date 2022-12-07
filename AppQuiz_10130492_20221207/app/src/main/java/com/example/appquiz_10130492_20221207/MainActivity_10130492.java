package com.example.appquiz_10130492_20221207;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity_10130492 extends AppCompatActivity {

    ArrayList<BookStore> bookStores = new ArrayList<>();
    BookAdapter adapter;
    TextView loading;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10130492);
        fab = findViewById(R.id.fab);
        loading = findViewById(R.id.load);


        RecyclerView recyclerView = findViewById(R.id.rec);
        recyclerView.setVisibility(View.INVISIBLE);
        adapter = new BookAdapter(bookStores);
        loading.setVisibility(View.VISIBLE);
        getData();

        recyclerView.setVisibility(View.VISIBLE);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        fab.setOnClickListener(i->{
            loading.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
            getData();
            recyclerView.setAdapter(adapter);
            recyclerView.setVisibility(View.VISIBLE);


        });


    }
    private void getData(){
        Response.Listener<JSONArray> response_listener = response -> {
            Log.d("JSON",response.toString());
            parseJson(response);

        };
        Response.ErrorListener response_errListener = err->{
          Log.e("JSON",err.toString());
        };
        String url = "https://cloud.culture.tw/frontsite/trans/emapOpenDataAction.do?method=exportEmapJson&typeId=M";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, response_listener, response_errListener);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }

    private void parseJson(JSONArray jsonArray){
        try{
            bookStores.clear();
            adapter.notifyDataSetChanged();
            Log.i("JSONParse",jsonArray.length()+"");
            for(int i = 0 ; i < jsonArray.length() ; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String cityName = jsonObject.getString("cityName");
                String openTime = jsonObject.getString("openTime");
                BookStore bookStore = new BookStore(name,cityName,openTime);
                Log.d("JSONData", String.format("Name: %s, City: %s",bookStore.getName(),bookStore.getCityName()));
                bookStores.add(bookStore);

            }
            adapter.notifyDataSetChanged();
            loading.setVisibility(View.INVISIBLE);

        }catch(Exception e){

            Log.e("JSON",e.toString());
        }
    }

}