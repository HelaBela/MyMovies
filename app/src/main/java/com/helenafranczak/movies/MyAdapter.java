package com.helenafranczak.movies;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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



    void addAll(ArrayList moviesArrayList){

       MainActivity.myAdapter1.addAll(moviesArrayList);



//        for(int i=0; i<moviesArrayList.size(); i++){
//
//            moviesArrayList.add()
//
//        }

        //addAll should internally populate this member variable ArrayList with the list you receive from your savedInstanceState

        //create addAll function should accept the list from the main activity and pass it to adapter

    }


    public MyAdapter(@NonNull Activity context, @NonNull ArrayList<Movie> movies) {

        mContext = context;
        moviesArrayList = movies;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       //creating a view
        Context context = parent.getContext();
        int layoutIDForGridView = R.layout.movie_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIDForGridView, parent, shouldAttachToParentImmediately);

        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


        final Movie movie =  moviesArrayList.get(position);

        Picasso.with(holder.moviePosterImageView.getContext()).load("http://image.tmdb.org/t/p/w185/"+ movie.getPoster()).into(holder.moviePosterImageView);


        holder.moviePosterImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Movie movieDetail =  moviesArrayList.get(position);

                Intent intent = new Intent(mContext , MovieDetails.class);
                intent.putExtra("movieDetail", movieDetail);
                mContext.startActivity(intent);

            }

        });

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView moviePosterImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            moviePosterImageView = (ImageView) itemView.findViewById(R.id.movie_image);

        }
    }



}
