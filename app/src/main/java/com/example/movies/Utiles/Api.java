package com.example.movies.Utiles;

import com.example.movies.Response.MovieSearchResponse;
import com.example.movies.Response.SeriesSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
// Movies
    @GET("movie/popular")
    Call<MovieSearchResponse> popularMovie(
            @Query("api_key") String key,
            @Query("page") int page
    );
    @GET("movie/top_rated")
    Call<MovieSearchResponse> topRatedMovie(
            @Query("api_key") String key,
            @Query("page") int page
    );
    @GET("movie/upcoming")
    Call<MovieSearchResponse> upcomingMovie(
            @Query("api_key") String key,
            @Query("page") int page
    );
    @GET("movie/now_playing")
    Call<MovieSearchResponse> nowPlayingMovie(
            @Query("api_key") String key,
            @Query("page") int page
    );
    @GET("search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String movie
    );


//Series
    @GET("tv/popular")
    Call<SeriesSearchResponse> popularSeries(
            @Query("api_key") String key,
            @Query("page") int page
    );
    @GET("tv/airing_today")
    Call<SeriesSearchResponse> airingTodaySeries(
            @Query("api_key") String key,
            @Query("page") int page
    );
    @GET("tv/on_the_air")
    Call<SeriesSearchResponse> onTheAirSeries(
            @Query("api_key") String key,
            @Query("page") int page
    );
    @GET("tv/top_rated")
    Call<SeriesSearchResponse> topRatedSeries(
            @Query("api_key") String key,
            @Query("page") int page
    );
    @GET("search/tv")
    Call<SeriesSearchResponse> searchSeries(
            @Query("api_key") String key,
            @Query("query") String movie
    );
}
