package com.example.rasyidk.newsapp.api;

import com.example.rasyidk.newsapp.model.DataNews;

public class JSONResponse {
    private DataNews[] News;

    public DataNews[] getNews() {
        return News;
    }

    public void setNews(DataNews[] news) {
        News = news;
    }
}
