package com.example.demo;

import com.example.demo.Task;

import java.util.*;

//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
	private List<Task> tasks = new ArrayList<>(
		    List.of(
		        new Task(1L, "Learn Spring Boot", "Understand REST API basics"),
		        new Task(2L, "Build Todo App", "Use ArrayList to store tasks")
		    )
		);
	
	@GetMapping("/tasks")
	public List<Task> getTask() {
		return tasks;
	}
	
	@PostMapping("/tasks")
	public List<Task> createTask(@RequestBody Task task) {
		tasks.add(task);
		return tasks;
	}
	
	@PutMapping("/tasks/{id}")
	public List<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
		for(Task t : tasks) {
			if (t.getId().equals(id)) {
				t.setTitle(updatedTask.getTitle());
				t.setDescription(updatedTask.getDescription());
			}
		}
		return tasks;
	}
	
	@DeleteMapping("/tasks/{id}")
	public List<Task> deleteTask(@PathVariable Long id) {
		tasks.removeIf(t -> t.getId().equals(id));
		return tasks;
	}

}