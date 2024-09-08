package com.gio.projects.book_search.controllers;

import com.gio.projects.book_search.models.Publisher;
import com.gio.projects.book_search.services.AddEntitiesService;
import com.gio.projects.book_search.services.PublishersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
public class PublishersController {

    private final PublishersRepository publishersRepository;
    private final AddEntitiesService<Publisher> entityService;

    @Autowired
    public PublishersController(PublishersRepository publishersRepository, AddEntitiesService<Publisher> entityService) {
        this.publishersRepository = publishersRepository;
        this.entityService = entityService;
    }

    @PostMapping("")
    public ResponseEntity<String> addPublisher(@RequestBody Publisher publisher) {
        return entityService.addEntity(publisher, "Publisher",
                p -> publishersRepository.findByNameIgnoreCase(p.getName()));
    }
}
