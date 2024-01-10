package de.htwberlin.webtech.webtech.web.service;

import de.htwberlin.webtech.webtech.web.entity.Task;
import de.htwberlin.webtech.webtech.web.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setCompleted(updatedTask.isCompleted());
            return taskRepository.save(existingTask);
        } else {
            // Handle case where task is not found
            return null;
        }
    }

    public boolean deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Task> getTasksByDate(String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return taskRepository.findByStartDate(parsedDate);
    }


    public List<Task> getTasksByDateRange(LocalDate startRange1, LocalDate endRange1,
                                          LocalDate startRange2, LocalDate endRange2) {
        return taskRepository.findByStartDateBetweenAndEndDateBetween(startRange1, endRange1, startRange2, endRange2);
    }
}
