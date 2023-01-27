package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    public void addDirectorMoviePair( String movie , String director){
       movieRepository.addDirectorMoviePair(movie,director);
    }
    public Movie findMovie(String movie){
        return movieRepository.findMovie(movie);
    }
    public Director findDirector( String director){
        return movieRepository.findDirector((director));
    }

    public List<String> findMovieByDirector( String director){
        return movieRepository.findMovieByDirector(director);
    }
    public List<String> findAllmovies(){
        return movieRepository.findAllmovies();
    }
    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }

    public  void deleteAllDirector(){
        movieRepository.deleteAllDirector();
    }

}
