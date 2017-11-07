package com.helenafranczak.movies;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by helenafranczak on 7/11/17.
 */

public class JSON {

    public static String[] getStringsFromJson(Context context, String movieInfo) {

        String MOVIE_RESULTS="results";

             /* String array to hold each movie's details  */
        String[] parsedMovieData = null;


        try {
            JSONObject jsonObject = new JSONObject(movieInfo);


            JSONArray resultsArray = jsonObject.getJSONArray(MOVIE_RESULTS);
            parsedMovieData = new String[resultsArray.length()];


            for (int i = 0; i < resultsArray.length(); i++) {

                /* These are the values that will be collected */
                String movieTitle;
                Integer moviePopularity;
                String moviePoster;

                /* Getting the JSON object representing one movie */

                JSONObject movieJson = resultsArray.getJSONObject(i);

                movieTitle = movieJson.getString("original_title");
                moviePopularity = movieJson.getInt("popularity");
                moviePoster = movieJson.getString("poster_path");


                parsedMovieData[i] = movieTitle + moviePopularity + moviePoster;


//              Object oneMovie = new oneMovie(title, popularity, poster);
//
//              ArrayList<Movie> myList = new ArrayList(resultsArray.length());

                // myList.add(oneMovie);

                // myList.add(title, popularity, poster);

               // Log.e("my movies", String.valueOf(movies));
            }


        } catch (JSONException e1) {
            e1.printStackTrace();
        }

     return parsedMovieData;
     }
}

