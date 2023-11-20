package com.proxidev.todoapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proxidev.todoapp.models.Task;
import com.proxidev.todoapp.repositories.TaskRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class TodoappApplication implements CommandLineRunner {
	@Autowired
	private final TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Task tasks1 = new Task(null, "J'aime spring boot", true);
		Task tasks2 = new Task(null, "J'aime django", true);
		Task tasks3 = new Task(null, "J'aime spring fastapi", false);

		taskRepository.saveAll(List.of(tasks1, tasks2, tasks3));

		List<Task> tasks = taskRepository.findAll();
		tasks.forEach(t -> {
			System.out.println(t.getName());
		});

	}

}
