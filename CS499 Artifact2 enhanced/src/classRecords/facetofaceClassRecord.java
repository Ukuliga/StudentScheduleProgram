/*
File: facetofaceClassRecord.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Constructs and defines the facetofaceClassRecord class.
    This class represents individual face-to-face class records, extending the functionality of the classRecord class.

*/

// Define the package for the class
package classRecords;

// Define the facetofaceClassRecord class, extending classRecord
public class facetofaceClassRecord extends classRecord {
	
	// Define additional attribute for classroom
	public String classroom;
	
	// Constructor to initialize a facetofaceClassRecord object
	public facetofaceClassRecord(String id, String courseId, String semester, String description, String professor, String classroom) {
		// Call the superclass constructor to initialize inherited attributes
		super(id, courseId, semester, description, professor);
		
		// Assign value to the additional attribute
		this.classroom = classroom;
	}
	
	// Getter method to retrieve the classroom attribute
	public String getClassroom() {
		return classroom;
	}

}
