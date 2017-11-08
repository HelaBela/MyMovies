package com.helenafranczak.movies;

import java.util.HashMap;

/**
 * Created by helenafranczak on 3/11/17.
 */

public class Movie  {

    public final String title;


    public final Integer popularity;


    public final String poster;


    public Movie(String movieTitle, Integer moviePopularity, String moviePoster) {
        title = movieTitle;
        popularity = moviePopularity;
        poster = moviePoster;
    }

//    public void setTitle(String title){
//        title= movieTitle;
//    }


}
