package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class MovieRepository {

   private Map<String , Movie> MovieMap;
   private Map<String , Director> DirectorMap;
   private Map<String, List<String>> DirectorMovieMap;

    public MovieRepository() {
        MovieMap =  new HashMap<>();
        DirectorMap = new HashMap<>();
        DirectorMovieMap = new HashMap<>();

    }

    public void addMovie(Movie movie){
        MovieMap.put(movie.getName(), movie);
    }
    public void addDirector(Director director){
        DirectorMap.put(director.getName(), director);
    }

    public void addDirectorMoviePair( String movie , String director){
        if(MovieMap.containsKey(movie) && DirectorMap.containsKey(director)){
            MovieMap.put( movie, MovieMap.get(movie));
            DirectorMap.put( director, DirectorMap.get(director));
            List<String> currDirectorMovie = new ArrayList<>();
            if(DirectorMovieMap.containsKey(director)) currDirectorMovie= DirectorMovieMap.get(director);
            currDirectorMovie.add(movie);
            DirectorMovieMap.put(director, currDirectorMovie);
        }
    }
    public Movie findMovie(String movie){
        return MovieMap.get(movie);
    }
    public Director findDirector( String director){
        return DirectorMap.get(director);
    }

    public List<String> findMovieByDirector( String director){
        List<String> movies = new ArrayList<>();
        if(DirectorMovieMap.containsKey(director)) movies= DirectorMovieMap.get(director);
        return movies;
    }
     public List<String> findAllmovies(){
        return new ArrayList<>(MovieMap.keySet());
     }
     public void deleteDirector(String director){
        List<String> movies = new ArrayList<>();
        if(DirectorMovieMap.containsKey(director)){
            movies= DirectorMovieMap.get(director);
            for(String movie : movies){
                if(MovieMap.containsKey(movie))
                    MovieMap.remove(movie);
            }
            DirectorMovieMap.remove(director);
        }
     }

     public  void deleteAllDirector(){
        HashSet<String> movieSet = new HashSet<>();

        for(String director : DirectorMovieMap.keySet()){
            for(String movie: DirectorMovieMap.get(director)){
                movieSet.add(movie);
            }
        }
        for(String movie : movieSet){
            if(MovieMap.containsKey(movie))
                MovieMap.remove(movie);
        }
     }







}
