package com.example.demo;

//import com.example.demo.Task;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {
//	private List<Task> tasks = new ArrayList<>(
//		    List.of(
//		        new Task(1L, "Learn Spring Boot", "Understand REST API basics"),
//		        new Task(2L, "Build Todo App", "Use ArrayList to store tasks")
//		    )
//		);
	
	@Autowired
	private TaskRepository taskrepository;
	
	@GetMapping
	public List<Task> getTask() {
//		return tasks;
		return taskrepository.findAll();
		
	}
	
//	@PostMapping
//	public Task createTask(@RequestBody Task task) {
////		tasks.add(task);
////		return tasks;
//		return taskrepository.save(task);
//	}
	
	@PostMapping
	public Task createTask(@Valid @RequestBody TaskDto taskDto) {
		// task entity
		Task task = new Task();
		task.setTitle(taskDto.getTitle());
		task.setDescription(taskDto.getDescription());
		return taskrepository.save(task);
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
//		for(Task t : tasks) {
//			if (t.getId().equals(id)) {
//				t.setTitle(updatedTask.getTitle());
//				t.setDescription(updatedTask.getDescription());
//			}
//		}
//		return tasks;
		return taskrepository.findById(id) // find for id
				.map(task -> { // if found do this
					task.setTitle(updatedTask.getTitle());
					task.setDescription(updatedTask.getDescription());
					return taskrepository.save(task);
				}) // if not then throw exception
				.orElseThrow(() -> new RuntimeException("Task not found."));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
//		tasks.removeIf(t -> t.getId().equals(id));
//		return tasks;
		taskrepository.deleteById(id);
	}

}