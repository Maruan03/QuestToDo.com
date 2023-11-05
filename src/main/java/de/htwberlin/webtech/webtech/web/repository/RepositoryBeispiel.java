package de.htwberlin.webtech.webtech.web.repository;

import de.htwberlin.webtech.webtech.web.entity.Beispiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBeispiel extends JpaRepository<Beispiel, Long> {
}
