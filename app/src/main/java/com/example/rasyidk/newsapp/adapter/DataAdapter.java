package com.example.rasyidk.newsapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rasyidk.newsapp.R;
import com.example.rasyidk.newsapp.model.DataNews;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<DataNews> news;

    public DataAdapter(ArrayList<DataNews> news) {
        this.news = news;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int i) {
        holder.kode.setText(news.get(i).getId());
        holder.title_news.setText(news.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView kode, title_news;
        public ViewHolder(View itemView) {
            super(itemView);
            kode = (TextView)itemView.findViewById(R.id.kode);
            title_news = (TextView)itemView.findViewById(R.id.title_news);
        }
    }
}
