/*
File: classRecord.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Constructs and defines the classRecord class.
    This class represents individual class records with attributes such as ID, course ID, semester, description, and professor.

*/

// Define the package for the class
package classRecords;

// Define the classRecord class
public class classRecord {
	
	// Define private attributes for the class record
	private String id;
	private String courseId;
	private String semester;
	private String description;
	private String professor;
	
	// Constructor to initialize a classRecord object
	public classRecord(String id, String courseId, String semester, String description, String professor) {
		// Validate input parameters
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(semester == null) {
			throw new IllegalArgumentException("semester field NULL");
		}
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		// Assign values to attributes
		this.id = id;
		this.courseId = courseId;
		this.semester = semester;
		this.description = description;
		this.professor = professor;
	}
	
	// Getter methods for retrieving attribute values
	public String getId() {
		return id;
	}
	
	public String getCourseId() {
		return courseId;
	}
	
	public String getSemester() {
		return semester;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getProfessor() {
		return professor;
	}
	
	// Setter method to update the description attribute
	public void setDescription(String Description) {
		// Validate the new description
		if(Description == null || Description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		// Update the description attribute
		this.description = Description;
	}
}
