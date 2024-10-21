/*
File: courseRecord.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Constructs and defines the courseRecord class.
    This class represents individual course records with attributes such as ID, hours, prerequisites, and description.

*/

// Define the package for the class
package courseRecords;

// Import necessary Java utilities
import java.util.List;
import java.util.ArrayList;

// Define the courseRecord class
public class courseRecord {
	
	// Define private attributes for the course record
	private String id;
	private int hours;
	private List<String> prerequisites;
	private String description;
	
	// Constructor to initialize a courseRecord object
	public courseRecord(String id, int hours, List<String> prerequisites, String description) {
		// Validate input parameters
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		// Assign values to attributes
		this.id = id;
		this.description = description;
		this.hours = hours;
		this.prerequisites = new ArrayList<>(prerequisites);
	}
	
	// Getter methods for retrieving attribute values
	public String getId() {
		return id;
	}
	
	public int getHours() {
		return hours;
	}
	
	public List<String> getPrerequisites() {
		return prerequisites;
	}
	
	// Setter method to update the prerequisites attribute
	public void setPrerequisites(List<String> prerequisites) {
		this.prerequisites = new ArrayList<>(prerequisites);
	}
	
	public String getDescription() {
		return description;
	}
	
	// Setter method to update the description attribute
	public void setDescription(String Description) {
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.description = Description;
	}
}
