package de.htwberlin.webtech.webtech.web.service;

import de.htwberlin.webtech.webtech.web.entity.Task;
import de.htwberlin.webtech.webtech.web.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        taskRepository.deleteById(id);
        return false;
    }
}
