package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        List<Movie>maximo = movies.stream()
                .reduce((acumulador,rating)->{
                    if (acumulador.getRating() > rating.getRating())
                        return acumulador;
                    else if (acumulador.getRating() == rating.getRating())
                        return acumulador;

                    return rating;
                })
                .stream().collect(Collectors.toList());

        Double MAX = maximo.get(0).getRating();
        System.out.println(MAX);
        return (MAX);


    }
}
