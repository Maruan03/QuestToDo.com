package de.htwberlin.webtech.webtech.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Beispiel {

    private String username; // Änderung des Attributnamens von "user" zu "username"

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
