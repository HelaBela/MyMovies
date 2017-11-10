package com.helenafranczak.movies;

import android.support.annotation.NonNull;

import java.util.HashMap;

/**
 * Created by helenafranczak on 3/11/17.
 */
//public class Movie implements Comparable<Movie> {

public class Movie {

    public String title;


    public  Integer popularity;


    public  String poster;


    public Movie(String movieTitle, Integer moviePopularity, String moviePoster) {
        title = movieTitle;
        popularity = moviePopularity;
        poster = moviePoster;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
       return title;

    }

    public void setPopularity(Integer popularity){
        this.popularity = popularity;
    }

    public  Integer getPopularity(){
        return popularity;

    }

    public void setPoster(String poster){
        this.poster = poster;
    }

    public  String getPoster(){
        return poster;

    }

//
//    @Override
//    public int compareTo(@NonNull Movie movieCompare) {
//        int comparePopularity = ((Movie)movieCompare).getPopularity();
//
//        return this.popularity-comparePopularity;
//    }
//




}







