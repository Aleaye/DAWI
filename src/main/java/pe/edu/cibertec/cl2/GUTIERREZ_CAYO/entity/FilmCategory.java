package pe.edu.cibertec.cl2.GUTIERREZ_CAYO.entity;
import jakarta.persistence.*;


import java.util.List;

public class FilmCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmCategoryId;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
