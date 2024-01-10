package de.htwberlin.webtech.webtech.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // GenerationType.AUTO anstatt GenerationType.IDENTITY
    private Long id;
    private String title;
    private String description;
    private LocalDate startDate; // Hinzufügen der Start- und Enddaten
    private LocalDate endDate;
    private boolean completed;

    // Leerer Konstruktor für JPA
    public Task() {}

    // Konstruktor für manuelle Erstellung von Tasks
    public Task(Long id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    // Getter und Setter für Task-Attribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
