package pe.edu.cibertec.cl2.GUTIERREZ_CAYO.service;

import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.dto.FilmDetailDto;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {
    List<FilmDto> findAllFilms();

    FilmDetailDto findFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);
    Boolean deleteFilm(int id);
    FilmDetailDto createFilm(FilmDetailDto filmDetailDto);

}
