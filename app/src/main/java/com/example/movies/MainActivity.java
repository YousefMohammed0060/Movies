package com.example.movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.res.Configuration;
import android.opengl.ETC1;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movies.Models.MovieAdapter;
import com.example.movies.Models.MovieModel;
import com.example.movies.Request.Services;
import com.example.movies.Response.MovieSearchResponse;
import com.example.movies.Utiles.Credentials;
import com.example.movies.Utiles.MovieApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    MovieAdapter movieAdapter;
    RecyclerView movieRv;
    EditText searchEt;
    InputMethodManager imm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieRv = findViewById(R.id.movieRv);
        searchEt = findViewById(R.id.searchEt);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            movieRv.setLayoutManager(new GridLayoutManager(this, 2));
        }
        else{
            movieRv.setLayoutManager(new GridLayoutManager(this, 4));
        }

        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getPopular();
        searchEt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                getSearchMovie();
                imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                return true;
            }
        });
    }


    private void getPopular() {
        MovieApi movieApi = Services.getMovieApi();
        Call<MovieSearchResponse> responseCall = movieApi
                .popularMovie(Credentials.API_KEY, 1);

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if (response.code() == 200) {
                    Log.v("Tag", "The response " + response.body().toString());

                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
                    movieAdapter = new MovieAdapter((ArrayList<MovieModel>) movies);
                    movieRv.setAdapter(movieAdapter);
                    searchEt.setText("");
                } else {
                    try {
                        Log.v("Tag", "Error " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });
    }

    private void getNowPlaying() {
        MovieApi movieApi = Services.getMovieApi();
        Call<MovieSearchResponse> responseCall = movieApi
                .nowPlayingMovie(Credentials.API_KEY, 1);

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if (response.code() == 200) {
                    Log.v("Tag", "The response " + response.body().toString());

                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
                    movieAdapter = new MovieAdapter((ArrayList<MovieModel>) movies);
                    movieRv.setAdapter(movieAdapter);
                    searchEt.setText("");
                } else {
                    try {
                        Log.v("Tag", "Error " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });
    }

    private void getUpcoming() {
        MovieApi movieApi = Services.getMovieApi();
        Call<MovieSearchResponse> responseCall = movieApi
                .upcomingMovie(Credentials.API_KEY, 1);

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if (response.code() == 200) {
                    Log.v("Tag", "The response " + response.body().toString());

                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
                    movieAdapter = new MovieAdapter((ArrayList<MovieModel>) movies);
                    movieRv.setAdapter(movieAdapter);
                    searchEt.setText("");

                } else {
                    try {
                        Log.v("Tag", "Error " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });
    }

    private void getTopRated() {
        MovieApi movieApi = Services.getMovieApi();
        Call<MovieSearchResponse> responseCall = movieApi
                .topRatedMovie(Credentials.API_KEY, 1);

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if (response.code() == 200) {
                    Log.v("Tag", "The response " + response.body().toString());

                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
                    movieAdapter = new MovieAdapter((ArrayList<MovieModel>) movies);
                    movieRv.setAdapter(movieAdapter);
                    searchEt.setText("");

                } else {
                    try {
                        Log.v("Tag", "Error " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });
    }

    private void getSearchMovie() {
        MovieApi movieApi = Services.getMovieApi();
        Call<MovieSearchResponse> responseCall = movieApi
                .searchMovie(Credentials.API_KEY, searchEt.getText().toString());

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if (response.code() == 200) {
                    Log.v("Tag", "The response " + response.body().toString());

                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
                    movieAdapter = new MovieAdapter((ArrayList<MovieModel>) movies);
                    movieRv.setAdapter(movieAdapter);

                } else {
                    try {
                        Log.v("Tag", "Error " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.popular:
                getPopular();
                return true;
            case R.id.topRated:
                getTopRated();
                return true;
            case R.id.upcoming:
                getUpcoming();
                return true;
            case R.id.nowPlaying:
                getNowPlaying();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void search(View view) {
        if (!searchEt.equals("")){
            getSearchMovie();
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            return;
        }
    }
}
