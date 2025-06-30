package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.Models.Movie;
import com.scaler.bookmyshow.Repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;

    public Movie getMovie(Long movieId){
        return movieRepository
                .findById(movieId)
                .orElseThrow(()-> new NoSuchElementException("Movie not found: " + movieId));
    }

    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }
}
