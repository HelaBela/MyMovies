package com.helenafranczak.movies;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    URL url;

    static MyAdapter myAdapter1;

    ArrayList<Movie> simpleJsonMovieResponse;
    RecyclerView recyclerView;

    ArrayList arrayListSaved;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList("arrayListKey", simpleJsonMovieResponse);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);



        gridView = (GridView) findViewById(R.id.grid);


        if (savedInstanceState != null) {

            arrayListSaved = savedInstanceState.getParcelableArrayList("arrayListKey");


            myAdapter1.addAll(arrayListSaved); //retrieving previously loaded list

            recyclerView.setAdapter(myAdapter1); //adding it to the adapter
           //setOnItemClickListener(??); ?  - do I need this here as well?


            //restore the scroll position - do I need a RecyclerView for that? - mentor said yes





        } else {

            //check if it's online first and then load the view.

        if (isOnline()) {

            url = NetworkUtils.buildUrl(NetworkUtils.POPULAR_URL);


            new MoviesQuery().execute(url);

        } else {

            Toast.makeText(this, "no internet conncetion", Toast.LENGTH_LONG).show();
        }
    }



//      gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//                //onclick listener in the adapter
//
//                Movie movieDetail = myAdapter1.getItem(position) ;
//                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
//                intent.putExtra("movieDetail", movieDetail);
//                startActivity(intent);
//
//
//            }
//        });


    }

    public class MoviesQuery extends AsyncTask<URL, Void, ArrayList<Movie>> {
        @Override
        protected ArrayList<Movie> doInBackground(URL... urls) {
            URL movieUrl = urls[0];
            String result = "";


            try {
                String jsonMovieResponse = NetworkUtils
                        .getResponseFromHttpUrl(movieUrl);

                simpleJsonMovieResponse = JSONparsing.getStringsFromJson(MainActivity.this, jsonMovieResponse);

                return simpleJsonMovieResponse;

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(ArrayList<Movie> result) {


            if(result!=null){

                myAdapter1 = new MyAdapter(MainActivity.this, result);

                recyclerView.setAdapter(myAdapter1);

                myAdapter1.notifyDataSetChanged();


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

        URL mUrl;

        int menuItemThatWasSelected = item.getItemId();

        if (isOnline()) {
            if (menuItemThatWasSelected == R.id.action_popularity) {

                mUrl = NetworkUtils.buildUrl(NetworkUtils.POPULAR_URL);

                new MoviesQuery().execute(mUrl);

            }

            if (menuItemThatWasSelected == R.id.action_rating) {


                mUrl = NetworkUtils.buildUrl(NetworkUtils.RATED_URL);

                new MoviesQuery().execute(mUrl);
            }

            return super.onOptionsItemSelected(item);
        } else {  Toast.makeText(this, "no internet conncetion", Toast.LENGTH_LONG).show();}
        return false;
    }

    private boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}





