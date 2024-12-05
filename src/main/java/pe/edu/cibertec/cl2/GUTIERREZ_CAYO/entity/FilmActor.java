package pe.edu.cibertec.cl2.GUTIERREZ_CAYO.entity;

import jakarta.persistence.*;

import java.util.Date;

public class FilmActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmActorID;
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;
}
