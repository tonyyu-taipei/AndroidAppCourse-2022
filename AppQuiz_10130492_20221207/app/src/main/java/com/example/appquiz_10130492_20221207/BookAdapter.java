package com.example.appquiz_10130492_20221207;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private ArrayList<BookStore> data;
    public BookAdapter(ArrayList<BookStore> d){
        data = d;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final BookStore bookStore = data.get(position);
        holder.city.setText(bookStore.getCityName());
        holder.name.setText(bookStore.getName());
        holder.time.setText(bookStore.getOpenTime());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView city;
        public TextView time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            city = itemView.findViewById(R.id.cityName);
            time = itemView.findViewById(R.id.openTime);
        }
    }
}
