package com.helenafranczak.movies;

import java.util.HashMap;

/**
 * Created by helenafranczak on 3/11/17.
 */

public class Movie  {

    public String title;


    public  Integer popularity;


    public  String poster;


    public Movie(String movieTitle, Integer moviePopularity, String moviePoster) {
        title = movieTitle;
        popularity = moviePopularity;
        poster = moviePoster;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
       return title;

    }

    public void setPopularity(Integer popularity){
        this.popularity = popularity;
    }

    public  Integer getPopularity(){
        return popularity;

    }

    public void setPoster(String poster){
        this.poster = poster;
    }

    public  String getPoster(){
        return poster;

    }

//    @Override
//    public int compareTo(Student comparestu) {
//        int compareage=((Student)comparestu).getStudentage();
//        /* For Ascending order*/
//        return this.studentage-compareage;
//
//        /* For Descending order do like this */
//        //return compareage-this.studentage;
//    }
//
//    @Override
//    public String toString() {
//        return "[ rollno=" + rollno + ", name=" + studentname + ", age=" + studentage + "]";
//    }
//
//}






}
