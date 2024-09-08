package com.gio.projects.book_search.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category extends UUIDBase {
    private String name;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
