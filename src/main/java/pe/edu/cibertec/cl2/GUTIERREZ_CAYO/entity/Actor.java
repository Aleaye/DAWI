package pe.edu.cibertec.cl2.GUTIERREZ_CAYO.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "actor")
    private List<FilmActor> filmActors;
}
