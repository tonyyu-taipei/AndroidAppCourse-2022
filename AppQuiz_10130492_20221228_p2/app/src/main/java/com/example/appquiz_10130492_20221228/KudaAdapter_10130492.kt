package com.example.appquiz_10130492_20221228

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class KudaAdapter_10130492(private val itemData: ArrayList<Scenary>) : RecyclerView.Adapter<KudaAdapter_10130492.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView
        val cityName: TextView
        val closeDay: TextView
        val address: TextView
        val rel: RelativeLayout


        init{
            name = view.findViewById(R.id.title_rec)
            cityName = view.findViewById(R.id.cityname_rec)
            closeDay = view.findViewById(R.id.closeday_rec)
            address = view.findViewById(R.id.addr)
            rel = view.findViewById(R.id.address_rec)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: Scenary = itemData[position]
        holder.name.text = data.name
        holder.cityName.text = data.cityName
        holder.closeDay.text = data.tel
        holder.address.text = data.address
        val infoObj = InfoObj(data.name,data.description)






    }

    override fun getItemCount(): Int {
        return itemData.size
    }
}