package com.gio.projects.book_search.models;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public class UUIDBase {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    private String id;

    public UUIDBase() {
    }

    @PrePersist
    protected void onCreate() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
