package com.gio.projects.book_search.services;


import com.gio.projects.book_search.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, String> {
    Optional<Author> findByNameIgnoreCase(String name);
}
