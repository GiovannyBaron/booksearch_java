package com.gio.projects.book_search.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Publisher")
public class Publisher extends UUIDBase {
    private String name;

    public Publisher() {}

    public Publisher(String nombre) {
        this.name = nombre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
