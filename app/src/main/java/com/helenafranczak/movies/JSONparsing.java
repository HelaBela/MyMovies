package com.helenafranczak.movies;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by helenafranczak on 7/11/17.
 */

public class JSONparsing {


    public static ArrayList<Movie> getStringsFromJson(Context context, String movieInfo) {

        String MOVIE_RESULTS = "results";

             /* String array to hold each movie's details  */
                String[] parsedMovieData = null;


        try {

            JSONObject jsonObject = new JSONObject(movieInfo);
            JSONArray resultsArray = jsonObject.getJSONArray(MOVIE_RESULTS);


           // Movie[] moviesArray = new Movie[resultsArray.length()];

            ArrayList<Movie> myList = new ArrayList(resultsArray.length());


            for (int i = 0; i < resultsArray.length(); i++) {

                /* These are the values that will be collected */
                String movieTitle;
                Integer moviePopularity;
                String moviePoster;

                /* Getting the JSONparsing object representing one movie */

                JSONObject movieJson = resultsArray.getJSONObject(i);

                movieTitle = movieJson.getString("original_title");
                moviePopularity = movieJson.getInt("popularity");
                moviePoster = movieJson.getString("poster_path");

                Movie oneMovie = new Movie(movieTitle, moviePopularity, moviePoster);

                myList.add(oneMovie);


                // parsedMovieData[i] = movieTitle + moviePopularity + moviePoster;

                //moviesArray[i] = new Movie(movieTitle, moviePopularity, moviePoster);


//                 ArrayList movieList = new ArrayList();
//
//                HashMap<String, String> one = new HashMap<>();
//
//                one.put("title", movieTitle);
//                one.put("popularity", String.valueOf(moviePopularity));
//                one.put("poster", moviePoster);
//
//                movieList.add(one);


//              Object oneMovie = new oneMovie(title, popularity, poster);
//
//              ArrayList<Movie> myList = new ArrayList(resultsArray.length());

                // myList.add(oneMovie);

                // myList.add(title, popularity, poster);

                // Log.e("my movies", String.valueOf(myMovies));
            }

            return myList;

        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}

