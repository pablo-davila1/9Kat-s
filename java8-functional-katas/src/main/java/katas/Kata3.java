package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Integer> calificaciones= movieLists.stream()
                .map(c -> c.getVideos())
                    .flatMap(c -> c.stream())
                    .map(c -> c.getId())
                    .collect(Collectors.toList());


        System.out.println(calificaciones);

        /*
        List<Object> NewmovieList = movieLists.stream()
                .map(c -> c.getVideos())
                .flatMap(c -> c.stream())
                .collect(Collectors.toList());
         */



        return calificaciones;
    }
}