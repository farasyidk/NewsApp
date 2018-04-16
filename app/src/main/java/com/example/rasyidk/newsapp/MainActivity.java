package com.example.rasyidk.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rasyidk.newsapp.adapter.DataAdapter;
import com.example.rasyidk.newsapp.api.JSONResponse;
import com.example.rasyidk.newsapp.api.Request;
import com.example.rasyidk.newsapp.model.DataNews;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<DataNews> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view();
    }

    private void view() {
        recyclerView = (RecyclerView)findViewById(R.id.card_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(LayoutManager);
        LoadJSON();
    }

    private void LoadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        Request request = retrofit.create(Request.class);
        Call<JSONResponse> call = request.getJSON();
        Log.d("errors", call.toString());
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getNews()));/*
                if (!data) {
                    adapter = new DataAdapter(data);
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.d("pesan", "Kosong");
                }*/
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });
    }

}
