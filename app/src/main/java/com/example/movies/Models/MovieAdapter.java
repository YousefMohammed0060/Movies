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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    View view;
    ArrayList<MovieModel> movies;

    public MovieAdapter(ArrayList<MovieModel> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        MovieHolder holder =new MovieHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, @SuppressLint("RecyclerView") int position) {
        Picasso.get().load("https://www.themoviedb.org/t/p/original"+movies.get(position).getPoster_path()).into(holder.moviePoster);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(view.getContext(), MoviesDetailsActivity.class);
                intent.putExtra("movie",movies.get(position));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder{
        ImageView moviePoster;
        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster=itemView.findViewById(R.id.poster);

        }
    }
}
