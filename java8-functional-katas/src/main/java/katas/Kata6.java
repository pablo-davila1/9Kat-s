package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        List<BoxArt> maximo = movies.stream()
                .map(c -> c.getBoxarts())
                .flatMap(c -> c.stream())
                .reduce((container,boxart)->{
                    if(container.getHeight()*container.getWidth() > boxart.getWidth()* boxart.getHeight())
                        return container;
                    else if (container.getHeight()*container.getWidth() == boxart.getWidth()* boxart.getHeight())
                        return container;
                    return boxart;
                })
                .stream().collect(Collectors.toList());
        System.out.println(maximo.get(0).getUrl());
        return (maximo.get(0).getUrl());
    }
}
