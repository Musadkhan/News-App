package com.example.musadkhan.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musadkhan.newsapp.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    NewsHeadlines newsHeadlines;
    TextView titleTxt,autherTxt,timeTxt,detailTxt;
    ImageView newsImg;
    Button readArticle;
    public static final String EXTRA_MSG = "com.example.musadkhan.newsapp.extra.MSG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        titleTxt = findViewById(R.id.NewsTitle);
        autherTxt = findViewById(R.id.NewsAuther);
        timeTxt = findViewById(R.id.NewsTime);
        detailTxt = findViewById(R.id.NewsDetail);
        newsImg = findViewById(R.id.newsImage);
        readArticle = findViewById(R.id.readArticle);

        newsHeadlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        titleTxt.setText(newsHeadlines.getTitle());
        autherTxt.setText(newsHeadlines.getAuthor());
        timeTxt.setText(newsHeadlines.getPublishedAt());
        detailTxt.setText(newsHeadlines.getDescription());

        if (newsHeadlines.getUrlToImage()!= null) {
            Picasso.get().load(newsHeadlines.getUrlToImage()).into(newsImg);
        }


        readArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = newsHeadlines.getUrl();
                Intent intent = new Intent(DetailsActivity.this,WebScreen.class);
                intent.putExtra(EXTRA_MSG,url);
                startActivity(intent);
            }
        });
    }
}