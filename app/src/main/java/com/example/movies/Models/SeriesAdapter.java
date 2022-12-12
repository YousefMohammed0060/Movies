package com.example.movies.Models;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.Movies.MoviesDetailsActivity;
import com.example.movies.R;
import com.example.movies.Series.SeriesDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesHolder> {
    View view;
    ArrayList<SeriesModel> series;

    public SeriesAdapter(ArrayList<SeriesModel> series) {
        this.series = series;
    }

    @NonNull
    @Override
    public SeriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        SeriesHolder holder =new SeriesHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesHolder holder, @SuppressLint("RecyclerView") int position) {
        Picasso.get().load("https://www.themoviedb.org/t/p/original"+series.get(position).getPoster_path()).into(holder.seriesPoster);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(view.getContext(), SeriesDetailsActivity.class);
                intent.putExtra("series",series.get(position));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    class SeriesHolder extends RecyclerView.ViewHolder{
        ImageView seriesPoster;
        public SeriesHolder(@NonNull View itemView) {
            super(itemView);
            seriesPoster=itemView.findViewById(R.id.poster);
        }
    }
}
