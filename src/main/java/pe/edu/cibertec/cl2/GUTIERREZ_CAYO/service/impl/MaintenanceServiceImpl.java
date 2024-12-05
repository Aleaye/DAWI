package pe.edu.cibertec.cl2.GUTIERREZ_CAYO.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.dto.FilmDetailDto;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.dto.FilmDto;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.entity.Film;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.repository.FilmRepository;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.repository.LanguageRepository;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.service.MaintenanceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<FilmDto> findAllFilms() {

        List<FilmDto> films = new ArrayList<>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDto filmDto = new FilmDto(film.getFilmId(),
                    film.getTitle(),
                    film.getLanguage().getName(),
                    film.getRentalDuration(),
                    film.getRentalRate());
            films.add(filmDto);
        });
        return films;

    }

    @Override
    public FilmDetailDto findFilmById(int id) {

        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(film -> new FilmDetailDto(film.getFilmId(),
                film.getTitle(),
                film.getDescription(),
                film.getReleaseYear(),
                film.getLanguage().getLanguageId(),
                film.getLanguage().getName(),
                film.getRentalDuration(),
                film.getRentalRate(),
                film.getLength(),
                film.getReplacementCost(),
                film.getRating(),
                film.getSpecialFeatures(),
                film.getLastUpdate())
        ).orElse(null);

    }

    @Override
    public Boolean updateFilm(FilmDetailDto filmDetailDto) {
        Optional<Film> optional = filmRepository.findById(filmDetailDto.filmId());
        return optional.map(
                film -> {film.setTitle(filmDetailDto.title());
                    film.setDescription(filmDetailDto.description());
                    film.setReleaseYear(filmDetailDto.releaseYear());
                    film.setRentalDuration(filmDetailDto.rentalDuration());
                    film.setRentalRate(filmDetailDto.rentalRate());
                    film.setLength(filmDetailDto.length());
                    film.setReplacementCost(filmDetailDto.replacementCost());
                    film.setRating(filmDetailDto.rating());
                    film.setSpecialFeatures(filmDetailDto.specialFeatures());
                    film.setLastUpdate(new Date());
                    filmRepository.save(film);
                    return true;
                }
        ).orElse(null);
    }

    @Override
    public FilmDetailDto createFilm(FilmDetailDto filmDetailDto) {
        Film film = new Film();
        film.setTitle(filmDetailDto.title());
        film.setDescription(filmDetailDto.description());
        film.setReleaseYear(filmDetailDto.releaseYear());
        film.setRentalDuration(filmDetailDto.rentalDuration());
        film.setRentalRate(filmDetailDto.rentalRate());
        film.setLength(filmDetailDto.length());
        film.setReplacementCost(filmDetailDto.replacementCost());
        film.setRating(filmDetailDto.rating());
        film.setSpecialFeatures(filmDetailDto.specialFeatures());
        film.setLastUpdate(new Date());
        film.setLanguage(languageRepository.findById(filmDetailDto.languageId()).orElse(null));
        film = filmRepository.save(film);
        return new FilmDetailDto(film.getFilmId(), film.getTitle(), film.getDescription(), film.getReleaseYear(),
                film.getLanguage().getLanguageId(), film.getLanguage().getName(), film.getRentalDuration(),
                film.getRentalRate(), film.getLength(), film.getReplacementCost(), film.getRating(),
                film.getSpecialFeatures(), film.getLastUpdate());
    }

    @Override
    public Boolean deleteFilm(int id) {
        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(film -> {
            filmRepository.delete(film);
            return true;
        }).orElse(false);
    }

}