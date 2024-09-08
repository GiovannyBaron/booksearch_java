package com.gio.projects.book_search.services;


import com.gio.projects.book_search.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, String> {
}
