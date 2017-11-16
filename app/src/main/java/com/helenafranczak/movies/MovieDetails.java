package com.helenafranczak.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {

    TextView titleTV;
    TextView plotTV;
    TextView ratingTV;
    TextView releaseTV;
    ImageView posterIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        titleTV = (TextView)findViewById(R.id.movieTitle);
        plotTV = (TextView)findViewById(R.id.plot);
        ratingTV = (TextView)findViewById(R.id.rating);
        releaseTV = (TextView)findViewById(R.id.release);

        posterIV= (ImageView)findViewById(R.id.posterImage);


        Intent intent = getIntent();

        Movie oneMovieDetails = intent.getParcelableExtra("movieDetail");


                titleTV.setText(oneMovieDetails.getTitle());
                plotTV.setText(oneMovieDetails.getPlot());
                ratingTV.setText(oneMovieDetails.getRating() + "/10");
                releaseTV.setText(oneMovieDetails.getDate());

         Picasso.with(posterIV.getContext())
         .load("http://image.tmdb.org/t/p/w185/"+ oneMovieDetails.getPoster())
        .into(posterIV);









    }
}
