package com.gio.projects.book_search.controllers;

import com.gio.projects.book_search.models.Category;
import com.gio.projects.book_search.services.AddEntitiesService;
import com.gio.projects.book_search.services.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoriesController {

    private final CategoriesRepository categoriesRepository;
    private final AddEntitiesService<Category> entityService;

    @Autowired
    public CategoriesController(CategoriesRepository categoriesRepository, AddEntitiesService<Category> entityService) {
        this.categoriesRepository = categoriesRepository;
        this.entityService = entityService;
    }

    @PostMapping("")
    public ResponseEntity<String> addCategory(@RequestBody Category category) {
        return entityService.addEntity(category, "Category",
                c -> categoriesRepository.findByNameIgnoreCase(c.getName()));
    }
}
