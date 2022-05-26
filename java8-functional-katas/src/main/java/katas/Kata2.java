package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import util.DataUtil;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        List<Integer> map_movies = new ArrayList<>();

        map_movies =movies.stream()
                .filter(element -> element.getRating() == 5)
                .map(element -> element.getRating().intValue())
                .collect(toList());

        System.out.println(map_movies);
        return (map_movies);


    }
}
