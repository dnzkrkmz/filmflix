package com.ax.library.controller;
import com.ax.library.domain.Film;
import com.ax.library.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@ComponentScan
@RestController
@RequestMapping("/")
public class FilmController {
    private final FilmService filmService;
    private static final Logger logger = LoggerFactory.getLogger(FilmController.class);

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }
    // can be used /films?page=0&size=10 for the first page
    @GetMapping("/films")
    public Page<Film> getAllFilms(Pageable pageable) {
        logger.info("Films requested by page.");
        Page<Film> films=filmService.getAllFilms(pageable);
        logger.debug("Returned {} films:",films.getSize());
        return films;
    }

    @GetMapping("/film/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.getFilmById(id);
    }
    @GetMapping("/films/number")
    public long numberOfFilms() {
        return filmService.getNumberOfFilms();
    }
    @PostMapping
    public Film createFilm(@RequestBody Film film) {
        return filmService.createFilm(film);
    }
    @PutMapping("/film/{id}")
    public Film updateFilm(@PathVariable Long id, @RequestBody Film updatedFilm) {
        return filmService.updateFilm(id, updatedFilm);
    }
    @DeleteMapping("/film/{id}")
    public void deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
    }

    @GetMapping("/swagger-ui")
    public String swaggerUi(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html?url=/v2/api-docs");
        return null;
    }
}
