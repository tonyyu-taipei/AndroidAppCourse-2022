package com.example.apptest1026_10130492;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private static OnItemClickListen listen = null;
    private MyListData[] listData;
    public MyListAdapter(MyListData[] listData, OnItemClickListen listen){
        this.listData = listData;
        this.listen = listen;
    }

    @NonNull
    @Override

    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_10130492,parent,false);
        ViewHolder viewholder = new ViewHolder(listItem);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
        final MyListData myListData = listData[position];
        holder.textView.setText(listData[position].getDescription());
        holder.imageView.setImageResource(listData[position].getImageId());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked On Item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageView;
        public RelativeLayout relativeLayout;
        public TextView textView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textDescription);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rl);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position!= RecyclerView.NO_POSITION){
                if (listen != null) listen.OnItemClick(position);

            }
        }
    }
    interface OnItemClickListen{
        void OnItemClick(int position);
    }
}
