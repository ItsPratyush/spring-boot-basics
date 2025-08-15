package com.example.demo;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

public class TaskDto {
	
	private Long id;
	@NotNull
	@Size(min = 5, max = 20, message = "Title must be between 5 and 20 characters.")
	private String title;
	@NotNull
	@Size(min = 10, max = 50, message = "Description must be between 10 and 50 characters.")
	private String description;
	
	public TaskDto() {
	}
	
	public TaskDto(Long id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
