package com.example.movies.Response;

import com.example.movies.Models.MovieModel;
import com.example.movies.Models.SeriesModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeriesResponse {
    @SerializedName("results")
    @Expose
    private SeriesModel series;

    public SeriesModel getSeries(){
        return series;
    }

    @Override
    public String toString() {
        return "SeriesResponse{" +
                "series=" + series +
                '}';
    }
}
