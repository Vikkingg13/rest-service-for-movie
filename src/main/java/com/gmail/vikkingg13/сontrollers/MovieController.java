package com.gmail.vikkingg13.сontrollers;

import com.gmail.vikkingg13.models.Movie;
import com.gmail.vikkingg13.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("id/{id}")
    public Movie findById(@PathVariable String id) {
        return movieService.findById(id);
    }

    @GetMapping("producer/{producer}")
    public List<Movie> findByProducer(@PathVariable String producer) {
        return movieService.findByProducer(producer);
    }

    @GetMapping("rating/{rating}")
    public List<Movie> findByRatingGreaterThanEqual(@PathVariable double rating) {
        return movieService.findByRatingGreaterThanEqual(rating);
    }

    @GetMapping("title/{title}")
    public List<Movie> findByTitle(@PathVariable String title) {
        return movieService.findByTitle(title);
    }

    @PostMapping
    public Movie saveOrUpdate(@RequestBody Movie movie) {
        return movieService.saveOrUpdate(movie);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        movieService.deleteById(id);
    }

}
