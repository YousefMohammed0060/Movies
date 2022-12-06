package com.example.movies.Utiles;

import com.example.movies.Response.MovieSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

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

}
