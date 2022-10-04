package com.example.musadkhan.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musadkhan.newsapp.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<NewsHeadlines> headlines;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.TitleTxt.setText(headlines.get(position).getTitle());
        holder.SourceTxt.setText(headlines.get(position).getSource().getName());

        if (headlines.get(position).getUrlToImage()!= null)
        {
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.HeadlineImg);
        }

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
