package com.ax.library.controller;
import com.ax.library.domain.Film;
import com.ax.library.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@ComponentScan
@RestController
@RequestMapping("/")
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/film/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.getFilmById(id);
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

    @GetMapping("/swagger-ui.html")
    public String swaggerUi(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html?url=/v2/api-docs");
        return null;
    }
}
