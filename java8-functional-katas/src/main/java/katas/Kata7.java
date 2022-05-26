package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map>externo =  movieLists.stream()
                .flatMap(c -> c.getVideos().stream())
                .map(movies -> {
                    return ImmutableMap.of("id", movies.getId(), "title", movies.getTitle());
                })
                .collect(Collectors.toList());

        System.out.println(externo.size());

        return externo;

    }

}
