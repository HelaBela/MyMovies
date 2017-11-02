package com.helenafranczak.movies;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import static com.helenafranczak.movies.NetworkUtils.MOVIES_URL;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public class MoviesQuery extends AsyncTask<URL, Void, String>{
        @Override
        protected String doInBackground(URL... params) {
            URL url = params[0];
            String result = null;

            try {
                result = NetworkUtils.getResponseFromHttpUrl(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.i("connected", MOVIES_URL.toString());
        }
    }


}
