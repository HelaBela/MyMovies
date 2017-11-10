package com.helenafranczak.movies;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by helenafranczak on 2/11/17.
 */

public class Adapter extends ArrayAdapter<Movie> {




    public Adapter(@NonNull Activity context, int resource, @NonNull ArrayList<Movie> movies) {
        super(context, 0, movies);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
// Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position

        Movie movie = getItem(position);

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_item, parent, false);

        }





       ImageView moviePosterTextView = (ImageView) convertView.findViewById(R.id.movie_image);
        //poster.setImageResource(androidFlavor.image);

        Picasso.with(moviePosterTextView.getContext()).load("http://image.tmdb.org/t/p/w185/"+ movie.getPoster()).into(moviePosterTextView);


//       TextView title = (TextView) convertView.findViewById(R.id.movie_image);
//       title.setText(movie.getTitle());
//
//        versionNameView.setText(androidFlavor.versionName
//         + " - " + androidFlavor.versionNumber );
//

        return convertView;

    }




}
