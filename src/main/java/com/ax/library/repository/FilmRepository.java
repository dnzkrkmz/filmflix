package com.ax.library.repository;


import com.ax.library.domain.Film;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface FilmRepository extends JpaRepository<Film, Long> {
    Logger logger = LogManager.getLogger(FilmRepository.class);
    default void repoCustomLog(String message) {
        logger.debug("Repo log: " + message);
    }
}