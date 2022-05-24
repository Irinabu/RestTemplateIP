package ro.ip.testMovieManagement.clients;

import java.util.List;
import ro.ip.testMovieManagement.models.MovieDto;

public interface MovieClient {

    List<MovieDto> getAllMovies();
    MovieDto getById(Long id);
    MovieDto addMovie(MovieDto movie);
    void updateMovie(Long id);
    void deleteMovie(Long id);
}