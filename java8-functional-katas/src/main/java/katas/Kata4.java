package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.*;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> listtolist = movieLists.stream()
                .map(c-> c.getVideos())
                .flatMap(c->c.stream())
                .map(boxart ->{
                    return(ImmutableMap.of("id",boxart.getId(),"title",boxart.getTitle(),"boxart",boxart.getBoxarts().stream()
                            .filter(c-> c.getHeight()==150 && c.getWidth()==200)));
                })
                .collect(Collectors.toList());

/*
        List<Movie> movieLists2 = movieLists.stream()
                .flatMap(c -> c.getVideos().stream())
                .collect(Collectors.toList());

        List<BoxArt> movieLists3 = movieLists2.stream()
                .flatMap(c-> c.getBoxarts().stream())
                .collect(Collectors.toList());

        List<BoxArt> movieLists4 = movieLists3.stream()
                .filter(c -> c.getHeight() == 200 && c.getWidth() == 150 )
                .collect(Collectors.toList());
 */


        return listtolist;
    }
}
