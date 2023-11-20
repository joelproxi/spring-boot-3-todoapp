package com.proxidev.todoapp.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proxidev.todoapp.models.Task;
import com.proxidev.todoapp.services.TaskService;

@RestController
public class TaskContoller {
    @Autowired
    private TaskService taskService;

    @GetMapping("api/v1/tasks")
    public Iterable<Task> getTaskList() {
        return taskService.getTaskList();
    }

    @GetMapping("api/v1/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PostMapping("api/v1/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("api/v1/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

    @DeleteMapping("api/v1/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted succefully";
    }
}
