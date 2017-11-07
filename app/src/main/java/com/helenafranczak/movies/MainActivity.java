package com.helenafranczak.movies;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

import static com.helenafranczak.movies.NetworkUtils.MOVIES_URL;

public class MainActivity extends AppCompatActivity {

    TextView text;
    TextView textResult;
    String title;
    String poster;
    Integer popularity;
    String[] parsedWeatherData = null;

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

    ArrayList<Movie> AllMovies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = (TextView) findViewById(R.id.text);

        //gridView = (GridView)findViewById(R.id.grid);

        textResult=(TextView)findViewById(R.id.textResult) ;

        URL url = NetworkUtils.buildUrl(MOVIES_URL);

        new MoviesQuery().execute(url);

        AllMovies = new ArrayList<Movie>();
        Movie object= new Movie(title, popularity, poster);
        AllMovies.add(object);

//        movies = new ArrayList<Movie>();
//
//
//        for (int i = 0; i < 20; i++) {
//
//            Movie movie = new Movie(title, popularity, poster);
//
//
//            movies.add(movie);
//
//        }

        //  parsedWeatherData

        //  movies = new ArrayList<Movie>(Arrays.asList(parsedWeatherData[]));

        //  GridView gridView = (GridView) findViewById(R.id.grid);
        //  gridView.setAdapter(adapter);

        //3 step to put the data from array of objects


//        for(int i=0; i<20; i++){
//
//            movies.add(new Movie (title, popularity, poster));
//        }
//
//        Log.e("my movies", movies.toString());


//
//        ArrayList<Movie> movies= new ArrayList<Movie>();
//        JSONArray resultsArray = (JSONArray)jsonObject;
//
//            for (int i=0;i<jArray.length();i++){
//               3 movies.add(jArray.getString(i));
//            }


//         public Movie(title, poster, popularity){
//
//
//
//        }
//
    }


    public class MoviesQuery extends AsyncTask<URL, Void, String[]> {
        @Override
        protected String[] doInBackground(URL... urls) {
            URL movieUrl = urls[0];
            String result = "";


            try {
                String jsonMovieResponse = NetworkUtils
                        .getResponseFromHttpUrl(movieUrl);

                String[] simpleJsonMovieResponse = JSON.getStringsFromJson(MainActivity.this, jsonMovieResponse);

                return simpleJsonMovieResponse;

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String[] result) {
            if(result!=null){


                for(String movieString: result){

                    Log.e("movies" , String.valueOf(AllMovies));

                   //textResult.append((movieString)+ "\n\n\n");

                }

            }






//        try{
//
//        JSONObject jsonObject = new JSONObject(result);
//        JSONArray resultsArray= jsonObject.getJSONArray("results");
//
//        //for loop to go thru each element of the results array . Index 0-19. Every element I will create . access each item
//            // new movie object and populate
//
//
//             /* String array to hold each movie's details  */
//
//            parsedWeatherData = new String[resultsArray.length()];
//
//
//            for( int i = 0; i<resultsArray.length(); i++){
//
//                /* Getting the JSON object representing one movie */
//
//                JSONObject movieJson = resultsArray.getJSONObject(i);
//
//                title = movieJson.getString("original_title");
//                popularity = movieJson.getInt("popularity");
//                poster = movieJson.getString("poster_path");
//
//
//
//                parsedWeatherData[i]= title+popularity+poster;
//
//
//
////              Object oneMovie = new oneMovie(title, popularity, poster);
////
////              ArrayList<Movie> myList = new ArrayList(resultsArray.length());
//
//               // myList.add(oneMovie);
//
//               // myList.add(title, popularity, poster);
//
//              Log.e("my movies", String.valueOf(movies));
//            }
//
//
//    }catch (JSONException e) {
//            e.printStackTrace();
//
//        }
//
        }
    }
}



