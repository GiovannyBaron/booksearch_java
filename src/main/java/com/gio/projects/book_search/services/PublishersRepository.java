package com.gio.projects.book_search.services;

import com.gio.projects.book_search.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishersRepository extends JpaRepository<Publisher, String> {
}
