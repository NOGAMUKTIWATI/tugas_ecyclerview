package com.example.nogacoding;

import android.os.Parcel;
import android.os.Parcelable;
//Implements Parcelable di kelas Movies
public class Movies implements Parcelable{
    //Deklarasi semua item sesuai yang ada di detail movie beserta TIPE DATAnya
    private  String tittle;
    private  String genre;
    private  String director;
    private double rating;
    private  String description;
    private  String releasedate;
    //Generate Constructor
    public Movies(String tittle, String genre, String director, double rating, String description, String releasedate) {
        this.tittle = tittle;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
        this.description = description;
        this.releasedate = releasedate;
    }
    //Generate setter and getter
    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }


    @Override
    public int describeContents() {
        return 0;
    }
    //Generate parcelable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tittle);
        dest.writeString(this.genre);
        dest.writeString(this.director);
        dest.writeDouble(this.rating);
        dest.writeString(this.description);
        dest.writeString(this.releasedate);
    }
    public void readFromParcel(Parcel source) {
        this.tittle = source.readString();
        this.genre = source.readString();
        this.director = source.readString();
        this.rating = source.readDouble();
        this.description = source.readString();
        this.releasedate = source.readString();
    }
    protected Movies(Parcel in) {
        this.tittle = in.readString();
        this.genre = in.readString();
        this.director = in.readString();
        this.rating = in.readDouble();
        this.description = in.readString();
        this.releasedate = in.readString();
    }
    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel source) {
            return new Movies(source);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
