package com.example.musadkhan.newsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView TitleTxt,SourceTxt;
    ImageView HeadlineImg;
    CardView cardView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        TitleTxt = (itemView).findViewById(R.id.newsHeadline);
        SourceTxt = (itemView).findViewById(R.id.newsSource);
        HeadlineImg = (itemView).findViewById(R.id.newsImage);
        cardView = (itemView).findViewById(R.id.newsCard);
    }
}
