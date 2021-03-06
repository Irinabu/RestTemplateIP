package ro.ip.testMovieManagement.models;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
public class MovieType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_generator")
    @SequenceGenerator(name="type_generator", sequenceName = "type_seq", allocationSize=1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String name;
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_generator")
    @SequenceGenerator(name="type_generator", sequenceName = "type_seq", allocationSize=1)
    private Type type;


    public MovieType(){}
    public MovieType(Type type) {
        this.type = type;
    }
}
