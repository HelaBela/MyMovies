package com.helenafranczak.movies;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by helenafranczak on 2/11/17.
 */

public class NetworkUtils {
    /** Tag for the log messages */
    public static final String LOG_TAG = NetworkUtils.class.getSimpleName();


    public static final String POPULAR_URL = "http://api.themoviedb.org/3/movie/popular?api_key=";

    public static final String RATED_URL = "http://api.themoviedb.org/3/movie/top_rated?api_key=";



    public static URL buildUrl(String MOVIES_URL){

        Uri builtUri;


        URL url = null;

        builtUri = Uri.parse(MOVIES_URL).buildUpon().build();


        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

}
