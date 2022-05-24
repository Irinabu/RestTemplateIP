
package ro.ip.testMovieManagement.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.ip.testMovieManagement.clients.MovieClient;
import ro.ip.testMovieManagement.models.MovieDto;

@Service
public class MovieClientImpl implements MovieClient {

    @Autowired
    RestTemplate restTemplate;

    final String ROOT_URI = "http://localhost:8080/api/v1/movies";

    public List<MovieDto> getAllMovies() {
        ResponseEntity<MovieDto[]> response = restTemplate.getForEntity(ROOT_URI, MovieDto[].class);
        return Arrays.asList(response.getBody());

    }

    public MovieDto getById(Long id) {
        ResponseEntity<MovieDto> response = restTemplate.getForEntity(ROOT_URI + "/"+id, MovieDto.class);
        return response.getBody();
    }

    public MovieDto addMovie(MovieDto movie) {
        ResponseEntity<MovieDto> response = restTemplate.postForEntity(ROOT_URI + "/create", movie, MovieDto.class);
        return response.getBody();
    }

    public void updateMovie(Long id) {
        restTemplate.put(ROOT_URI + "/" + id, MovieDto.class);

    }

    public void deleteMovie(Long id) {
       restTemplate.delete(ROOT_URI + "/" + id);

    }
}
