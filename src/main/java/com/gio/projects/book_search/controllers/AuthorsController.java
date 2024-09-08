package com.gio.projects.book_search.controllers;

import com.gio.projects.book_search.models.Author;
import com.gio.projects.book_search.services.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/author")
public class AuthorsController {
    @Autowired
    private AuthorsRepository authorsRepository;

    @PostMapping("")
    public ResponseEntity<String> addAuthor(@RequestBody Author author) {
        Optional<Author> existingAuthor = authorsRepository.findByNameIgnoreCase(author.getName());
        if (existingAuthor.isPresent()) {
            return new ResponseEntity<>("Author already exists", HttpStatus.CONFLICT);
        }

        Author savedAuthor = authorsRepository.save(author);

        String successMessage = "Author %s created successfully";
        return new ResponseEntity<>(String.format(successMessage, savedAuthor.getName()), HttpStatus.CREATED);
    }
}
