package com.scaler.bookmyshow.Controllers;

import com.scaler.bookmyshow.DTOS.CreateMovieRequest;
import com.scaler.bookmyshow.Models.Movie;
import com.scaler.bookmyshow.Services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable Long id){
        return movieService.getMovie(id);
    }

    @PostMapping("/movie")
    public Movie createMovie(@RequestBody CreateMovieRequest request){
        return movieService.createMovie(request.toMovie());
    }
}
