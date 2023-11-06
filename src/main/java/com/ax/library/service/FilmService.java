package com.ax.library.service;


import com.ax.library.domain.Film;
import com.ax.library.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
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
