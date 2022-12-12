package com.example.movies.Series;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.movies.Models.SeriesModel;
import com.example.movies.Movies.MovieActivity;
import com.example.movies.Movies.MoviesDetailsActivity;
import com.example.movies.R;
import com.squareup.picasso.Picasso;

public class SeriesDetailsActivity extends AppCompatActivity {
    ImageView seriesPosterIv;
    TextView firstAirDate,seriesOverviewTv,seriesTitleTv;
    RatingBar seriesRatingBar;
    SeriesModel series;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_details);
        series = getIntent().getParcelableExtra("series");
        seriesPosterIv=findViewById(R.id.seriesPosterIv);
        firstAirDate=findViewById(R.id.firstAirDate);
        seriesOverviewTv=findViewById(R.id.seriesOverviewTv);
        seriesTitleTv=findViewById(R.id.seriesTitleTv);
        seriesRatingBar=findViewById(R.id.seriesRatingBar);
        Picasso.get().load("https://www.themoviedb.org/t/p/original"+series.getBackdrop_path()).into(seriesPosterIv);
        firstAirDate.append(series.getFirst_air_date());
        seriesOverviewTv.append(series.getOverview());
        seriesTitleTv.append(series.getOriginal_name());
        seriesRatingBar.setRating(10-series.getVote_average());
    }


}