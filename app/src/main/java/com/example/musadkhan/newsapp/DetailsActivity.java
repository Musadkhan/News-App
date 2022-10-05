package com.example.musadkhan.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musadkhan.newsapp.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    NewsHeadlines newsHeadlines;
    TextView titleTxt,autherTxt,timeTxt,detailTxt;
    ImageView newsImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        titleTxt = findViewById(R.id.NewsTitle);
        autherTxt = findViewById(R.id.NewsAuther);
        timeTxt = findViewById(R.id.NewsTime);
        detailTxt = findViewById(R.id.NewsDetail);
        newsImg = findViewById(R.id.newsImage);

        newsHeadlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        titleTxt.setText(newsHeadlines.getTitle());
        autherTxt.setText(newsHeadlines.getAuthor());
        timeTxt.setText(newsHeadlines.getPublishedAt());
        detailTxt.setText(newsHeadlines.getDescription());

        if (newsHeadlines.getUrlToImage()!= null) {
            Picasso.get().load(newsHeadlines.getUrlToImage()).into(newsImg);
        }
    }
}