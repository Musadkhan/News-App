package com.example.musadkhan.newsapp;

import com.example.musadkhan.newsapp.Models.NewsHeadlines;

import java.util.List;

public interface onFetchDataListener<NewsApiResponse>{

    void onFetchData(List<NewsHeadlines> list ,String message);
    void onError(String message);
}
