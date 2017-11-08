package com.helenafranczak.movies;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static com.helenafranczak.movies.NetworkUtils.MOVIES_URL;

public class MainActivity extends AppCompatActivity {

    TextView text;
    TextView textResult;
    String title;
    String poster;
    Integer popularity;

    GridView gridView;

    // Adapter adapter;

    //Movie[] movies;

//    Movie[] movies={
//            new Movie ("title",823, "http://image.tmdb.org/t/p/"+"w185" + poster)
//
//    };
//

    //step 2 create array list of type movie object here. 20 movie objects will come here.

    // how to populate array list with objects

    ArrayList<HashMap<String, String>> AllMovies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = (TextView) findViewById(R.id.text);

      //  gridView = (GridView)findViewById(R.id.grid);

       // textResult=(TextView)findViewById(R.id.textResult) ;

        URL url = NetworkUtils.buildUrl(MOVIES_URL);

        AllMovies= new ArrayList<>();

        new MoviesQuery().execute(url);
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


                   Log.e("my movies", String.valueOf(result));


//              Movie movie =new Movie(poster, popularity, title);
//               AllMovies.add(movie);

                 //The onPostExecute() takes a String[] result as an input, which is the simpleJsonMovieResponse returned by the doInBackground().
                    //  That string is the answer received from the server and it’s in JSON format, so you have to parse it


                    //text.append((movieString)+ "\n\n\n");
             // Log.e("my movies", movieString);
            }



                }

            }


        }





