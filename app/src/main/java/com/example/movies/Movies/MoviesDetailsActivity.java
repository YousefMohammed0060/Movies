package com.example.movies.Movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.movies.Models.MovieModel;
import com.example.movies.R;
import com.squareup.picasso.Picasso;

public class MoviesDetailsActivity extends AppCompatActivity {
    ImageView posterIv;
    TextView releaseDateTv,overviewTv,titleTv;
    RatingBar ratingBar;
    MovieModel movie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        movie = getIntent().getParcelableExtra("movie");
        posterIv=findViewById(R.id.posterIv);
        releaseDateTv=findViewById(R.id.releaseDateTv);
        overviewTv=findViewById(R.id.overviewTv);
        titleTv=findViewById(R.id.titleTv);
        ratingBar=findViewById(R.id.ratingBar);
        Picasso.get().load("https://www.themoviedb.org/t/p/original"+movie.getBackdrop_path()).into(posterIv);
        releaseDateTv.append(movie.getRelease_date());
        overviewTv.append(movie.getOverview());
        titleTv.append(movie.getTitle());
        ratingBar.setRating(10-movie.getVote_average());
    }



}