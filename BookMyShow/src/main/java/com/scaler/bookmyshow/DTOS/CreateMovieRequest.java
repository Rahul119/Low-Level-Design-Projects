package com.scaler.bookmyshow.DTOS;

import com.scaler.bookmyshow.Enums.Language;
import com.scaler.bookmyshow.Enums.MovieFeature;
import com.scaler.bookmyshow.Models.Movie;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreateMovieRequest {
    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<MovieFeature> features = new ArrayList<>();

    public Movie toMovie(){
        return Movie.builder()
                .name(name)
                .rating(rating)
                .features(features)
                .languages(languages)
                .build();
    }
}
