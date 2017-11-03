package com.helenafranczak.movies;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeoutException;

import static com.helenafranczak.movies.NetworkUtils.MOVIES_URL;

public class MainActivity extends AppCompatActivity {

    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = (TextView) findViewById(R.id.text);

        URL url = NetworkUtils.buildUrl(MOVIES_URL);

        new MoviesQuery().execute(url);
}


public class MoviesQuery extends AsyncTask<URL, Void, String> {
    @Override
    protected String doInBackground(URL... urls) {
        URL movieUrl = urls[0];
        String result = "";


        try {
            result = NetworkUtils.getResponseFromHttpUrl(movieUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try{

        JSONObject jsonObject = new JSONObject(result);
        JSONArray resultsArray= jsonObject.getJSONArray("results");

        JSONObject firstMovie = resultsArray.getJSONObject(0);

        String title = firstMovie.getString("original_title");
        Integer popularity = firstMovie.getInt("popularity");
        String poster = firstMovie.getString("poster_path");

        Log.e("title", title);

    }catch (JSONException e) {
            e.printStackTrace();

        }
    }
}
}



