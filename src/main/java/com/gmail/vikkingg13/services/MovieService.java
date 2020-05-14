package com.gmail.vikkingg13.services;

import com.gmail.vikkingg13.models.Movie;

import java.util.List;
import java.util.Set;

public interface MovieService {
    Movie saveOrUpdate(Movie movie);
    List<Movie> findAll();
    Movie findById(String id);
    List<Movie> findByProducer(String producer);
    List<Movie> findByRatingGreaterThanEqual(double rating);
    List<Movie> findByTitle(String title);
    void deleteById(String id);

}
