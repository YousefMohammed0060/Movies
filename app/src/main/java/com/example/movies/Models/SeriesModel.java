package com.example.movies.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class SeriesModel implements Parcelable {
    private String original_name;
    private String poster_path;
    private String backdrop_path;
    private float vote_average;
    private String overview;
    private String first_air_date;

    public SeriesModel(String original_name, String poster_path, String backdrop_path, float vote_average, String overview, int number_of_seasons, String first_air_date) {
        this.original_name = original_name;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.vote_average = vote_average;
        this.overview = overview;
        this.first_air_date = first_air_date;
    }

    protected SeriesModel(Parcel in) {
        original_name = in.readString();
        poster_path = in.readString();
        backdrop_path = in.readString();
        vote_average = in.readFloat();
        overview = in.readString();
        first_air_date = in.readString();
    }

    public static final Creator<SeriesModel> CREATOR = new Creator<SeriesModel>() {
        @Override
        public SeriesModel createFromParcel(Parcel in) {
            return new SeriesModel(in);
        }

        @Override
        public SeriesModel[] newArray(int size) {
            return new SeriesModel[size];
        }
    };

    public String getOriginal_name() {
        return original_name;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }



    public String getFirst_air_date() {
        return first_air_date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(original_name);
        parcel.writeString(poster_path);
        parcel.writeString(backdrop_path);
        parcel.writeFloat(vote_average);
        parcel.writeString(overview);
        parcel.writeString(first_air_date);
    }
}
