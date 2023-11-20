package com.proxidev.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proxidev.todoapp.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
