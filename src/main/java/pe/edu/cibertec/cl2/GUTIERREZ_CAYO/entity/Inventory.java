package pe.edu.cibertec.cl2.GUTIERREZ_CAYO.entity;

import jakarta.persistence.*;

import java.util.Date;

public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer inventoryId;
    public Integer storeId;
    public Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "film_id")
    public Film film;
}
