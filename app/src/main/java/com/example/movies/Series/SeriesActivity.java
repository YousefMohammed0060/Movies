package com.example.movies.Series;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.movies.Models.MovieAdapter;
import com.example.movies.Models.MovieModel;
import com.example.movies.Models.SeriesAdapter;
import com.example.movies.Models.SeriesModel;
import com.example.movies.R;
import com.example.movies.Request.Services;
import com.example.movies.Response.MovieSearchResponse;
import com.example.movies.Response.SeriesSearchResponse;
import com.example.movies.Utiles.Api;
import com.example.movies.Utiles.Credentials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesActivity extends AppCompatActivity {
    Toolbar toolbar;
    SeriesAdapter seriesAdapter;
    RecyclerView seriesRv;
    EditText searchEt;
    InputMethodManager imm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        seriesRv = findViewById(R.id.seriesRv);
        searchEt = findViewById(R.id.searchSeriesEt);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            seriesRv.setLayoutManager(new GridLayoutManager(this, 2));
        }
        else{
            seriesRv.setLayoutManager(new GridLayoutManager(this, 4));
        }

        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getPopular();
        searchEt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                getSearchedSeries();
                imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                return true;
            }
        });
    }

    private void getSearchedSeries() {
        Api api = Services.getApi();
        Call<SeriesSearchResponse> responseCall = api
                .searchSeries(Credentials.API_KEY, searchEt.getText().toString());
        responseCall.enqueue(new Callback<SeriesSearchResponse>() {
            @Override
            public void onResponse(Call<SeriesSearchResponse> call, Response<SeriesSearchResponse> response) {
                if (response.code() == 200) {
                    Log.v("Tag", "The response " + response.body().toString());

                    List<SeriesModel> series = new ArrayList<>(response.body().getSeries());
                    seriesAdapter = new SeriesAdapter((ArrayList<SeriesModel>) series);
                    seriesRv.setAdapter(seriesAdapter);
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
            public void onFailure(Call<SeriesSearchResponse> call, Throwable t) {

            }
        });
    }

    private void getPopular() {
        Api api = Services.getApi();
        Call<SeriesSearchResponse> responseCall = api
                .popularSeries(Credentials.API_KEY, 1);
        responseCall.enqueue(new Callback<SeriesSearchResponse>() {
            @Override
            public void onResponse(Call<SeriesSearchResponse> call, Response<SeriesSearchResponse> response) {
                if (response.code() == 200) {
                    Log.v("Tag", "The response " + response.body().toString());

                    List<SeriesModel> series = new ArrayList<>(response.body().getSeries());
                    seriesAdapter = new SeriesAdapter((ArrayList<SeriesModel>) series);
                    seriesRv.setAdapter(seriesAdapter);
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
            public void onFailure(Call<SeriesSearchResponse> call, Throwable t) {

            }
        });
    }

    private void getTopRated() {
        Api api = Services.getApi();
        Call<SeriesSearchResponse> responseCall = api
                .topRatedSeries(Credentials.API_KEY, 1);
        responseCall.enqueue(new Callback<SeriesSearchResponse>() {
            @Override
            public void onResponse(Call<SeriesSearchResponse> call, Response<SeriesSearchResponse> response) {
                if (response.code() == 200) {
                    Log.v("Tag", "The response " + response.body().toString());

                    List<SeriesModel> series = new ArrayList<>(response.body().getSeries());
                    seriesAdapter = new SeriesAdapter((ArrayList<SeriesModel>) series);
                    seriesRv.setAdapter(seriesAdapter);
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
            public void onFailure(Call<SeriesSearchResponse> call, Throwable t) {

            }
        });
    }

    private void getOnTheAir() {
        Api api = Services.getApi();
        Call<SeriesSearchResponse> responseCall = api
                .onTheAirSeries(Credentials.API_KEY, 1);
        responseCall.enqueue(new Callback<SeriesSearchResponse>() {
            @Override
            public void onResponse(Call<SeriesSearchResponse> call, Response<SeriesSearchResponse> response) {
                if (response.code() == 200) {
                    Log.v("Tag", "The response " + response.body().toString());

                    List<SeriesModel> series = new ArrayList<>(response.body().getSeries());
                    seriesAdapter = new SeriesAdapter((ArrayList<SeriesModel>) series);
                    seriesRv.setAdapter(seriesAdapter);
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
            public void onFailure(Call<SeriesSearchResponse> call, Throwable t) {

            }
        });
    }

    private void getAiringToday() {
        Api api = Services.getApi();
        Call<SeriesSearchResponse> responseCall = api
                .airingTodaySeries(Credentials.API_KEY, 1);
        responseCall.enqueue(new Callback<SeriesSearchResponse>() {
            @Override
            public void onResponse(Call<SeriesSearchResponse> call, Response<SeriesSearchResponse> response) {
                if (response.code() == 200) {
                    Log.v("Tag", "The response " + response.body().toString());

                    List<SeriesModel> series = new ArrayList<>(response.body().getSeries());
                    seriesAdapter = new SeriesAdapter((ArrayList<SeriesModel>) series);
                    seriesRv.setAdapter(seriesAdapter);
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
            public void onFailure(Call<SeriesSearchResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.series_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.popular:
                getPopular();
                return true;
            case R.id.topRatedSeries:
                getTopRated();
                return true;
            case R.id.airingToday:
                getAiringToday();
                return true;
            case R.id.onTheAir:
                getOnTheAir();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    public void search(View view) {
        if (!searchEt.equals("")){
            getSearchedSeries();
            imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            return;
        }
    }
}