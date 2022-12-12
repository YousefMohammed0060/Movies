package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.movies.Movies.MovieActivity;
import com.example.movies.Series.SeriesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tvShowsClicked(View view) {
        startActivity(new Intent(MainActivity.this, SeriesActivity.class));
    }

    public void moviesClicked(View view) {
        startActivity(new Intent(MainActivity.this, MovieActivity.class));
    }
}