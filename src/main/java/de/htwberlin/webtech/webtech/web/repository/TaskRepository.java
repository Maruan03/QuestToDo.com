package de.htwberlin.webtech.webtech.web.repository;

import de.htwberlin.webtech.webtech.web.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Benutzerdefinierte Methoden für spezielle Abfragen werden hier definiert
    // List<Task> findByCompleted(boolean completed);
}
