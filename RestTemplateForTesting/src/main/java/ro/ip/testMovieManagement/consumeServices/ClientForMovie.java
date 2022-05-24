
package ro.ip.testMovieManagement.consumeServices;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ip.testMovieManagement.clients.MovieClient;
import ro.ip.testMovieManagement.config.ClientConfig;
import ro.ip.testMovieManagement.models.ActorDto;
import ro.ip.testMovieManagement.models.MovieDto;
import ro.ip.testMovieManagement.models.MovieType;

import java.util.Arrays;

import static ro.ip.testMovieManagement.models.Type.ACTION;
import static ro.ip.testMovieManagement.models.Type.COMEDY;

public class ClientForMovie {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ClientConfig.class);

        MovieClient client = applicationContext.getBean(MovieClient.class);

        System.out.println("Getting list of all people:");

        for (MovieDto p : client.getAllMovies()) {
            System.out.println(p);
        }

        System.out.println("\nGetting Movie with ID 2");

        MovieDto movieById = client.getById(1L);

        System.out.println(movieById);

        System.out.println("Adding a Movie");
        MovieDto MOVIE_1 = new MovieDto("Curierul1", "film actiune",  Arrays.asList(new ActorDto("Jason Statham")),
                Arrays.asList(new MovieType(ACTION), new MovieType(COMEDY)), true);

        MovieDto insertedMovie = client.addMovie(MOVIE_1);
        System.out.println("Add Movie Response = " + insertedMovie);

        applicationContext.close();
    }
}
