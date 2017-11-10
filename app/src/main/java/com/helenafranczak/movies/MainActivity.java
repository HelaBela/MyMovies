package com.helenafranczak.movies;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import static com.helenafranczak.movies.NetworkUtils.MOVIES_URL;

public class MainActivity extends AppCompatActivity {

    TextView text;

    GridView gridView;

    ArrayAdapter<Movie> myAdapter;

    ArrayList<Movie> moviesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     text = (TextView) findViewById(R.id.text);

      gridView = (GridView)findViewById(R.id.grid);

      moviesList = new ArrayList<Movie>();




        URL url = NetworkUtils.buildUrl(MOVIES_URL);

        new MoviesQuery().execute(url);

        myAdapter = new Adapter(this, 0 , moviesList);

        gridView.setAdapter(myAdapter);

    }

    public class MoviesQuery extends AsyncTask<URL, Void, ArrayList<Movie>> {
        @Override
        protected ArrayList<Movie> doInBackground(URL... urls) {
            URL movieUrl = urls[0];
            String result = "";


            try {
                String jsonMovieResponse = NetworkUtils
                        .getResponseFromHttpUrl(movieUrl);

                ArrayList<Movie> simpleJsonMovieResponse = JSONparsing.getStringsFromJson(MainActivity.this, jsonMovieResponse);

                return simpleJsonMovieResponse;

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(ArrayList<Movie> result) {
            if(result!=null){

                myAdapter.addAll(result);
                myAdapter.notifyDataSetChanged();

                //Log.e("myArray", String.valueOf(moviesArray));

            }

    }

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int menuItemThatWasSelected= item.getItemId();
        if(menuItemThatWasSelected==R.id.action_popularity){

            //Context context = MainActivity.this;

//            Collections.sort(moviesList, new Comparator<Movie>() {
//                @Override
//                public int compare(Movie movie, Movie nextMovie) {
//                    return 0;
//                }
//            });


        }

        if(menuItemThatWasSelected==R.id.action_rating){

            Context context = MainActivity.this;



        }


        return super.onOptionsItemSelected(item);
    }
}





