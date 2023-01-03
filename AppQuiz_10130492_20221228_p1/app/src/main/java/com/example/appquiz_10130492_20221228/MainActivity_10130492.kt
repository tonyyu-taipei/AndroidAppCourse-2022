package com.example.appquiz_10130492_20221228

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity_10130492 : AppCompatActivity() {
    private lateinit var readBtn: Button
    private lateinit var name: TextView
    private lateinit var intro: TextView
    var scenaryList = ArrayList<Scenary>()
    private val url = "https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvAttractions.aspx"
    override fun onCreate(savedInstanceState: Bundle?) {
        context = this
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_10130492)
        readBtn = findViewById(R.id.btnRead)
        name  = findViewById(R.id.name)
        intro = findViewById(R.id.intro)
        readBtn.setOnClickListener{

            //getData_JSONObject()
            load()


        }

    }

    private fun parseJson(json: JSONArray){

        Log.i("JSON",json.toString())
        scenaryList.clear()
        for(i in 0 until json.length()){
            val jsonObj = json.getJSONObject(i)
            val s = Scenary(jsonObj.getString("Name"),jsonObj.getString("City"),jsonObj.getString("Tel"),jsonObj.getString("Address"),jsonObj.getString("Introduction"))
            name.text = s.name
            intro.text = s.description
            scenaryList.add(s)
        }



    }
    fun load(){
        val responseListener = Response.Listener<JSONArray> {
            parseJson(it)
        }
        val reponseError = Response.ErrorListener {
            it.printStackTrace()
        }
        val jsonArrayRequest = JsonArrayRequest(url,responseListener,reponseError)
        val queue = Volley.newRequestQueue(this)
        queue.add(jsonArrayRequest)

    }

    companion object{
        lateinit var data: InfoObj
        lateinit var context: Context
    }
}