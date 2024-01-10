package de.htwberlin.webtech.webtech.web.repository;

import de.htwberlin.webtech.webtech.web.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStartDateBetweenAndEndDateBetween(LocalDate startRange1, LocalDate endRange1,
                                                       LocalDate startRange2, LocalDate endRange2);

    List<Task> findByStartDate(LocalDate date); // Filtern nach Startdatum
}



