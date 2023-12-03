package de.htwberlin.webtech.webtech.web.controller;

import de.htwberlin.webtech.webtech.web.entity.Beispiel;
import de.htwberlin.webtech.webtech.web.repository.RepositoryBeispiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/beispiele")
public class BeispielController {

    @Autowired
    private final RepositoryBeispiel repositoryBeispiel;

    @Autowired
    public BeispielController(RepositoryBeispiel repositoryBeispiel) {
        this.repositoryBeispiel = repositoryBeispiel;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beispiel> getBeispielById(@PathVariable Long id) {
        Optional<Beispiel> beispiel = repositoryBeispiel.findById(id);
        return beispiel.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/beispiel")
    public ResponseEntity<Beispiel> showBeispielPage() {
        Beispiel beispiel = new Beispiel();
        beispiel.setId(4L);
        beispiel.setUsername("Test");
        return ResponseEntity.ok(beispiel);
    }


    @PostMapping
    public ResponseEntity<Beispiel> createBeispiel(@RequestBody Beispiel beispiel) {
        repositoryBeispiel.save(beispiel);
        return ResponseEntity.ok(beispiel);
    }


    @PutMapping("/put/{id}")
    public ResponseEntity<Beispiel> updateBeispiel(@PathVariable Long id, @RequestBody Beispiel updatedBeispiel) {
        Optional<Beispiel> existingBeispielOptional = repositoryBeispiel.findById(id);

        if (existingBeispielOptional.isPresent()) {
            Beispiel existingBeispiel = existingBeispielOptional.get();
            existingBeispiel.setUsername(updatedBeispiel.getUsername()); // Aktualisiere den Attributnamen

            repositoryBeispiel.save(existingBeispiel);
            return ResponseEntity.ok(existingBeispiel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeispiel(@PathVariable Long id) {
        if (repositoryBeispiel.existsById(id)) {
            repositoryBeispiel.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
