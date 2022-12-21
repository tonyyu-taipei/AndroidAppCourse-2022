package com.example.appquiz_10130492_20221221

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import java.io.IOException

class MainActivity_10130492 : AppCompatActivity() {
    private lateinit var readBtn: Button
    private lateinit var con: ConstraintLayout

    private val url = "https://gis.taiwan.net.tw/XMLReleaseALL_public/scenic_spot_C_f.json"
    override fun onCreate(savedInstanceState: Bundle?) {
        context = this
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_10130492)
        readBtn = findViewById(R.id.btnRead)
        con = findViewById(R.id.con1)
        var jsonRes: ArrayList<Scenary> = ArrayList<Scenary>()
        val adapter = McuAdapter_10130492(jsonRes)
        readBtn.setOnClickListener{
            //getData_JSONObject()
            val loadRes = load()
            jsonRes.clear()
            jsonRes.addAll(parseJson(JSONObject(loadRes)))
            adapter.notifyDataSetChanged()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.rec)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        con.setOnClickListener {

        }
    }

    private fun parseJson(json: JSONObject): ArrayList<Scenary>{
        var jsonArr = json.getJSONObject("XML_Head").getJSONObject("Infos").getJSONArray("Info")
        var scenaryList = ArrayList<Scenary>()
        for(i in 0 until jsonArr.length()){
            val jsonObj = jsonArr.getJSONObject(i)

            scenaryList.add(Scenary(jsonObj.getString("Name"),jsonObj.getString("Region"),jsonObj.getString("Opentime"),jsonObj.getString("Add"),jsonObj.getString("Toldescribe")))
        }

        return scenaryList
    }
    fun load(): String?{
        var json: String
        try{
            val fileInputStream = assets.open("scenic_spot_C_f.json")
            var size = fileInputStream.available()
            var buffer = ByteArray(size)
            fileInputStream.read(buffer)
            fileInputStream.close()
            json = String(buffer,Charsets.UTF_8)

        }catch(ex: IOException){
            ex.printStackTrace()
            return null
        }
        return json
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