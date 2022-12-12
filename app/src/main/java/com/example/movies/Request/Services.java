package com.example.movies.Request;

import static com.example.movies.Utiles.Credentials.BASE_URL;

import com.example.movies.Utiles.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Services {
    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit =retrofitBuilder.build();

    private static Api api = retrofit.create(Api.class);

    public static Api getApi(){
        return api;
    }
}
