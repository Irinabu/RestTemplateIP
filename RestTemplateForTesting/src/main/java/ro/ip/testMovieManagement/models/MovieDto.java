package ro.ip.testMovieManagement.models;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
public class MovieDto {

    @NotNull
    private String name;
    private String description;
    private List<ActorDto> actors;
    @NotNull
    private List<MovieType> type;
    private String duration;
    private String director;
    private String writer;
    private boolean hasCaptions;
    private Date releaseDate;

    // Images
    private Integer imdbId;
    private String posterPath;
    private String backdropPath;

    // votes
    private Double voteAverage;
    private Long voteCount;

    public MovieDto(String name, String description, List<ActorDto> actors, List<MovieType> type, boolean hasCaptions) {
        this.name = name;
        this.description = description;
        this.actors = actors;
        this.type = type;
        this.hasCaptions = hasCaptions;
    }

}
