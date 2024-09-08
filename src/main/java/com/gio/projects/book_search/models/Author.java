package com.gio.projects.book_search.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Author")
public class Author extends UUIDBase {
    @Column(nullable = false)
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
