package com.helenafranczak.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {

    TextView titleTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        titleTV = (TextView)findViewById(R.id.movieTitle);

        Intent intent = getIntent();

        Movie oneMovieDetails = intent.getParcelableExtra("movie");

        if(intent != null){
            if(intent.hasExtra("movie")){

                String title = intent.getStringExtra("movie");



                titleTV.setText(oneMovieDetails.getTitle());



            }

        }


    }
}
