package com.example.appquiz_10130492_20221228

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.appquiz_10130492_20221228.databases.ScenariesDB
import org.json.JSONArray

class MainActivity_10130492 : AppCompatActivity() {
    private lateinit var readBtn: Button
    private lateinit var con: ConstraintLayout
    private lateinit var adapter: KudaAdapter_10130492;
    var scenaryList = ArrayList<Scenary>()
    private val url = "https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvAttractions.aspx"
    override fun onCreate(savedInstanceState: Bundle?) {
        context = this
        super.onCreate(savedInstanceState)
        Toast.makeText(this,"已載入資料庫現有資料",Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_10130492)
        readBtn = findViewById(R.id.btnRead)
        con = findViewById(R.id.con1)
        var db = ScenariesDB(this)
        scenaryList.clear()
        scenaryList.addAll(db.readAll())
        adapter = KudaAdapter_10130492(scenaryList)
        readBtn.setOnClickListener{

            //getData_JSONObject()
            load()
            val scenaries = db.readAll()
            scenaryList.addAll(scenaries)
            Log.i("JSON", "arrrrrrList $scenaries")
            adapter.notifyDataSetChanged()

        }
        val recyclerView = findViewById<RecyclerView>(R.id.rec)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun parseJson(json: JSONArray){
        val db = ScenariesDB(context)

        Log.i("JSON",json.toString())
        scenaryList.clear()
        for(i in 0 until json.length()){
            val jsonObj = json.getJSONObject(i)
            db.insert(Scenary(jsonObj.getString("Name"),jsonObj.getString("City"),jsonObj.getString("Tel"),jsonObj.getString("Address"),jsonObj.getString("Introduction")))
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
        fun run(){
            val bundle = Bundle()
            val infoObj = data
            val intent = Intent()
            intent.setClass(context,SecondActivity_10130492::class.java)
            bundle.putSerializable("obj",infoObj)
            intent.putExtras(bundle)
            startActivity(context,intent,bundle)
        }
    }
}