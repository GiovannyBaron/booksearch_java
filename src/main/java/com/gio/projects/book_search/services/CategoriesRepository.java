package com.gio.projects.book_search.services;


import com.gio.projects.book_search.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, String> {
    Optional<Category> findByNameIgnoreCase(String name);

}
