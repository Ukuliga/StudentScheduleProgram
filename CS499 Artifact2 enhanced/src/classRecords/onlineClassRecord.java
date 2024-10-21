/*
File: onlineClassRecord.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Constructs and defines the onlineClassRecord class.
    This class represents individual online class records, extending the functionality of the classRecord class.

*/

// Define the package for the class
package classRecords;

// Define the onlineClassRecord class, extending classRecord
public class onlineClassRecord extends classRecord {
	
	// Define additional attributes for online classes
	private String courseURL;
	private String onlineCode;
	
	// Constructor to initialize an onlineClassRecord object
	public onlineClassRecord(String id, String courseId, String semester, String description, String professor, String courseURL, String onlineCode) {
		// Call the superclass constructor to initialize inherited attributes
		super(id, courseId, semester, description, professor);
		
		// Assign values to the additional attributes
		this.courseURL = courseURL;
		this.onlineCode = onlineCode;
	}
	
	// Getter methods to retrieve the online class attributes
	public String getCourseURL() {
		return courseURL;
	}
	
	public String getOnlineCode() {
		return onlineCode;
	}
}
