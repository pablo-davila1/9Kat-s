package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();

        List<Map> map_movies = movies.stream()
                .map(c-> {
                    return (ImmutableMap.of("id",c.getId(),"title",c.getTitle()));
                }).collect(Collectors.toList());


        System.out.println(map_movies.size());

        return map_movies;
        //return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys"));
    }
}