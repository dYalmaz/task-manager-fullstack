package com.example.task.controller;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5011")
@RestController
@RequestMapping("/api/tasks") // All links will start with /api/tasks
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAllByOrderBySortOrderAsc();
    }

    // Create a new task
    @PostMapping
    public Task createTask(@Valid@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // Delete a task by ID
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        // Search for the existing task. If it's not there, throw an error.
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        // Update the fields
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setSortOrder(taskDetails.getSortOrder());

        // Save the updated task back to the database
        return taskRepository.save(task);
    }

}