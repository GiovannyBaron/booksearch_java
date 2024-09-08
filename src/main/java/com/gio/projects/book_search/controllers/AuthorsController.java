package com.gio.projects.book_search.controllers;

import com.gio.projects.book_search.models.Author;
import com.gio.projects.book_search.services.AddEntitiesService;
import com.gio.projects.book_search.services.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorsController {

    private final AuthorsRepository authorsRepository;
    private final AddEntitiesService<Author> entityService;

    @Autowired
    public AuthorsController(AuthorsRepository authorsRepository, AddEntitiesService<Author> entityService) {
        this.authorsRepository = authorsRepository;
        this.entityService = entityService;
    }

    @PostMapping("")
    public ResponseEntity<String> addAuthor(@RequestBody Author author) {
        return entityService.addEntity(author, "Author",
                a -> authorsRepository.findByNameIgnoreCase(a.getName()));
    }
}
