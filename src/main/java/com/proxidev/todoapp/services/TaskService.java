package com.proxidev.todoapp.services;

import org.springframework.stereotype.Service;

import com.proxidev.todoapp.models.Task;
import com.proxidev.todoapp.repositories.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository tRepository) {
        this.taskRepository = tRepository;
    }

    public Iterable<Task> getTaskList() {
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        return taskRepository.findById(Long.valueOf(id)).orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = this.getTask(id);
        taskRepository.delete(task);
    }

}
