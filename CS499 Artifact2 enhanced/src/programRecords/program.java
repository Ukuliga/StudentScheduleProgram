/*
File: program.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Constructs and defines the program class.
    This class represents individual program records with attributes such as ID, required courses, required hours, and degree type.

*/


// Define the package for the class
package programRecords;

// Import necessary Java utilities
import java.util.ArrayList;
import java.util.List;

// Define the program class
public class program {
	// Define private attributes for the program record
	private String id;
	private List<String> coursesRequired;
	private int hoursRequired;
	private String degreeType;
		
	// Constructor to initialize a program record object
	public program(String id, List<String> coursesRequired, int hoursRequired, String degreeType) {
		// Validate input parameters
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		
		// Assign values to attributes
		this.id = id;
		this.coursesRequired = coursesRequired;
		this.hoursRequired = hoursRequired;
		this.degreeType = degreeType;
	}
	
	// Getter methods for retrieving attribute values
	public String getId() {
		return id;
	}
	
	public List<String> getCoursesRequired() {
		return coursesRequired;
	}
	
	public int getHoursRequired() {
		return hoursRequired;
	}
	
	// Setter method to update the required courses
	public void setCoursesRequired(List<String> coursesRequired) {
		this.coursesRequired = new ArrayList<>(coursesRequired);
	}
	
	public String getDegreeType() {
		return degreeType;
	}

}
