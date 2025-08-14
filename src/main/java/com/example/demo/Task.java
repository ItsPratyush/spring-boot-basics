package com.example.demo;

//import lombok.Data;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Task {
	
	private Long id;
	private String title;
	private String description;
	
	public Task() {
		// No-args constructor
	}
	
	public Task(Long id, String title, String description) {
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
