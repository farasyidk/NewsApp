package com.example.rasyidk.newsapp.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Request {
    @GET("top-headlines?country=id&category=technology&pageSize=5&apiKey=0fcfe927537f45c0a2b8a1757d6f8b2f")
    Call<JSONResponse> getJSON();
}
