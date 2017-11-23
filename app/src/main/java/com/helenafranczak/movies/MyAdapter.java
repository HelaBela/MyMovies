package com.helenafranczak.movies;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by helenafranczak on 2/11/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

    ArrayList<Movie> moviesArrayList = new ArrayList<>();
    Context mContext;

    ImageView moviePosterImageView;

    public MyAdapter(@NonNull Activity context, @NonNull ArrayList<Movie> movies) {

        mContext = context;
        moviesArrayList = movies;
        //super(context, movies); It calls the constructor of the superclass so it's not needed here right?
        // I had it in the previous version of the code


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       //creating a view
        Context context = parent.getContext();
        int layoutIDForGridView = R.layout.activity_main;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIDForGridView, parent, shouldAttachToParentImmediately);

        MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.viewHolderImage. // .setImage... many options, but none looks like I could use with Picasso.

        return viewHolder;
    }

    //big problem with this below, please see my concers and tries

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // here is what i found in forum:
//
//            // - get element from your dataset at this position
//            // - replace the contents of the view with that element
//            holder.mTextView.setText(mDataset[position]);
//
        Movie movie = getItem(position); // - get element from your dataset at this position, dont know how to do it

        moviePosterImageView = (ImageView) convertView.findViewById(R.id.movie_image);

        // do I put here Picasso code?
        Picasso.with(moviePosterImageView.getContext()).load("http://image.tmdb.org/t/p/w185/"+ movie.getPoster()).into(moviePosterImageView);

        // this is from the course:
//        String weatherForThisDay = mWeatherData[position];
//        forecastAdapterViewHolder.mWeatherTextView.setText(weatherForThisDay);

        /**
         * OnBindViewHolder is called by the RecyclerView to display the data at the specified
         * position. In this method, we update the contents of the ViewHolder to display the weather
         * details for this particular position, using the "position" argument that is conveniently
         * passed into us.
         *
         * @param holder The ViewHolder which should be updated to represent the
         *                                  contents of the item at the given position in the data set.
         * @param position                  The position of the item within the adapter's data set.
         */

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView viewHolderImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            viewHolderImage= moviePosterImageView;

        }
    }

   // void bind(ArrayList moviesArrayList){ //

       // moviePosterImageView set to movie.getPoster() meaning Picasso has to be used here?

   // }

    //ArrayAdapter<Movie>;




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
// Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position

        Movie movie = getItem(position);

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_item, parent, false);

        }





       moviePosterImageView = (ImageView) convertView.findViewById(R.id.movie_image);
        //poster.setImageResource(androidFlavor.image);

        Picasso.with(moviePosterImageView.getContext()).load("http://image.tmdb.org/t/p/w185/"+ movie.getPoster()).into(moviePosterImageView);


//       TextView title = (TextView) convertView.findViewById(R.id.movie_image);
//       title.setText(movie.getTitle());
//
//        versionNameView.setText(androidFlavor.versionName
//         + " - " + androidFlavor.versionNumber );
//

        return convertView;

    }




}
