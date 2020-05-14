package com.gmail.vikkingg13.services.impls;

import com.gmail.vikkingg13.models.Movie;
import com.gmail.vikkingg13.repository.MovieRepository;
import com.gmail.vikkingg13.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveOrUpdate(Movie movie) {
        Movie savedMovie;
        if (movie.getId() != null && movieRepository.existsById(movie.getId())) {
            savedMovie = movieRepository.findById(movie.getId()).get();
            savedMovie.setTitle(movie.getTitle());
            savedMovie.setGenre(movie.getGenre());
            savedMovie.setProducer(movie.getProducer());
            savedMovie.setRating(movie.getRating());
        } else {
            savedMovie = movie;
            savedMovie.setId(UUID.randomUUID().toString());
        }
        return movieRepository.save(savedMovie);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(String id) {
        return movieRepository.findById(id).orElseThrow(
                RuntimeException::new
        );
    }

    @Override
    public List<Movie> findByProducer(String producer) {
        return movieRepository.findByProducer(producer);
    }

    @Override
    public List<Movie> findByRatingGreaterThanEqual(double rating) {
        return movieRepository.findByRatingGreaterThanEqual(rating);
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public void deleteById(String id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }
}
