package com.example.movies.Response;

import com.example.movies.Models.MovieModel;
import com.example.movies.Models.SeriesModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeriesSearchResponse {
    @SerializedName("total_results")
    @Expose()
    private int total_count;

    @SerializedName("results")
    @Expose()
    private List<SeriesModel> series;

    public int getTotal_count(){
        return total_count;
    }

    public List<SeriesModel> getSeries(){
        return series;
    }

    @Override
    public String toString() {
        return "SeriesSearchResponse{" +
                "total_count=" + total_count +
                ", series=" + series +
                '}';
    }
}
