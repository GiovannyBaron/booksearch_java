package com.gio.projects.book_search.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class AddEntitiesService<T> {
    private final JpaRepository<T, String> repository;

    public AddEntitiesService(JpaRepository<T, String> repository) {
        this.repository = repository;
    }

    public ResponseEntity<String> addEntity(T entity, String entityName, Function<T, Optional<T>> findByNameFunction) {
        Optional<T> existingEntity = findByNameFunction.apply(entity);
        if (existingEntity.isPresent()) {
            return new ResponseEntity<>(entityName + " already exists", HttpStatus.CONFLICT);
        }

        T savedEntity = repository.save(entity);
        String successMessage = String.format("%s %s created successfully", entityName, savedEntity.toString());
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
}
