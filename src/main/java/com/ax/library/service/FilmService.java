package com.ax.library.service;


import com.ax.library.domain.Film;
import com.ax.library.repository.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;
    private static final Logger logger = LoggerFactory.getLogger(FilmService.class);

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Page<Film> getAllFilms(Pageable pageable) {
        logger.info("Getting films from the database.");
        Page<Film> films = filmRepository.findAll(pageable);
        logger.debug("Retrieved {} films from database.", films.getSize());
        return films;
    }
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
    public long getNumberOfFilms(){
        return getAllFilms().size();
    }
    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    public Film updateFilm(Long id, Film updatedFilm) {
        Film existingFilm = filmRepository.findById(id).orElse(null);
        if (existingFilm != null) {
            return filmRepository.save(existingFilm);
        } else {
            return null;
        }
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }
}
