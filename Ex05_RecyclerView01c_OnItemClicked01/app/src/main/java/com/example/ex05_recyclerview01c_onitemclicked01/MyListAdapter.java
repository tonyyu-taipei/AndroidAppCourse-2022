package com.example.ex05_recyclerview01c_onitemclicked01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private static OnItemClickListen listen = null;
    private ArrayList<MyListData> listItem = new ArrayList<MyListData>();
    public MyListAdapter(ArrayList<MyListData> list, OnItemClickListen listen){
        listItem = list;
        this.listen = listen;
    }

    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()) ;
        View listItem = layoutInflater.inflate(R.layout.listitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
        final MyListData myListData = listItem.get(position);
        holder.textView.setText(listItem.get(position).getDescription());
        holder.imageView.setImageResource(listItem.get(position).getImgId());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Click On Item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder( View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView1);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rel);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                if(listen!=null){
                    listen.OnItemClick(position);
                }
            }
        }
    }
    interface OnItemClickListen{
        void OnItemClick(int position);
    }
}
