package com.example.movies.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {
    // Model class of our movies
    private String title;
    private String poster_path;
    private String backdrop_path;
    private String release_date;
    private int movie_id;
    private float vote_average;
    private String overview;

    //Constructor

    public MovieModel(String title, String poster_path, String backdrop_path, String release_date, int movie_id, float vote_average, String overview) {
        this.title = title;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.release_date = release_date;
        this.movie_id = movie_id;
        this.vote_average = vote_average;
        this.overview = overview;
    }


    //Getters

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(poster_path);
        parcel.writeString(backdrop_path);
        parcel.writeString(release_date);
        parcel.writeInt(movie_id);
        parcel.writeFloat(vote_average);
        parcel.writeString(overview);
    }
    protected MovieModel(Parcel in) {
        title = in.readString();
        poster_path = in.readString();
        backdrop_path = in.readString();
        release_date = in.readString();
        movie_id = in.readInt();
        vote_average = in.readFloat();
        overview = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };
}
