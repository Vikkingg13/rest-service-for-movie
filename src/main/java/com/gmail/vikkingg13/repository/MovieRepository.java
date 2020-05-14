package com.gmail.vikkingg13.repository;

import com.gmail.vikkingg13.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByTitle(String title);
    List<Movie> findByProducer(String producer);
    List<Movie> findByRatingGreaterThanEqual(double rating);
}
