package de.htwberlin.webtech.webtech;

import de.htwberlin.webtech.webtech.web.entity.Task;
import de.htwberlin.webtech.webtech.web.repository.TaskRepository;
import de.htwberlin.webtech.webtech.web.service.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest

class TaskServiceTests {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    @DisplayName("Get all tasks - Success")
    void getAllTasks_ReturnsTasks() {
        // Mock-Verhalten für taskRepository.findAll() setzen
        Task task1 = new Task(1L, "Task 1", "Description 1", false);
        Task task2 = new Task(2L, "Task 2", "Description 2", true);
        Mockito.when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        // Test durchführen
        List<Task> result = taskService.getAllTasks();
        assertEquals(2, result.size());
        assertEquals("Task 1", result.get(0).getTitle());
        assertEquals("Task 2", result.get(1).getTitle());
    }

    @Test
    @DisplayName("Get task by ID - Existing ID")
    void getTaskById_ExistingId_ReturnsTask() {
        // Mock-Verhalten für taskRepository.findById() setzen
        Task task = new Task(1L, "Task 1", "Description 1", false);
        Mockito.when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        // Test durchführen
        Optional<Task> result = taskService.getTaskById(1L);
        assertTrue(result.isPresent());
        assertEquals("Task 1", result.get().getTitle());
    }

    @Test
    @DisplayName("Get task by ID - Non-existing ID")
    void getTaskById_NonExistingId_ReturnsEmptyOptional() {
        // Mock-Verhalten für taskRepository.findById() setzen
        Mockito.when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        // Test durchführen
        Optional<Task> result = taskService.getTaskById(1L);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Get tasks by date - Success")
    void getTasksByDate_ReturnsTasks() {
        // Mock-Verhalten für taskRepository.findByStartDate() setzen
        LocalDate date = LocalDate.now();
        Task task1 = new Task(1L, "Task 1", "Description 1", false);
        Task task2 = new Task(2L, "Task 2", "Description 2", true);
        Mockito.when(taskRepository.findByStartDate(date)).thenReturn(Arrays.asList(task1, task2));

        // Test durchführen
        List<Task> result = taskService.getTasksByDate(date.toString());
        assertEquals(2, result.size());
        assertEquals("Task 1", result.get(0).getTitle());
        assertEquals("Task 2", result.get(1).getTitle());
    }

    // Weitere Tests für andere Methoden des TaskService
}
