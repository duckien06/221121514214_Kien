package com.example.a221121514214_LeDucKien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a221121514214_LeDucKien.R;
import com.example.a221121514214_LeDucKien.model.Item;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context context;
    private List<Item> list;

    public NewsAdapter(Context context, List<Item> list){
        this.context = context;
        this.list = list;
    }

    public void reloadData(List<Item> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position){
        Item model = list.get(position);
        holder.tvDate.setText(model.getDate());
        holder.tvTitle.setText(model.getTitle());
        holder.tvContent.setText(model.getContent());
        Glide.with(context).load(model.getImage()).into(holder.ivCover);
    }

    @Override
    public int getItemCount(){
        return list.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView tvDate, tvTitle, tvContent;
        ImageView ivCover;

        public NewsViewHolder (@NonNull View itemView){
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvContent);
            ivCover = itemView.findViewById(R.id.ivCover);
        }
    }
}