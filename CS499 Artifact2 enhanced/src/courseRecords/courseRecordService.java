/*
File: courseRecordService.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Constructs and defines the courseRecordService class.
    This class provides services for managing courseRecord objects.

*/


// Define the package for the class
package courseRecords;

// Import necessary Java utilities
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// Define the courseRecordService class
public class courseRecordService {
	// Creating an empty HashMap to store course records
    private static HashMap<String, courseRecord> course_map = new HashMap<String, courseRecord>();
    
    // Method to add a new course record
    public static void addCourse(String id, int hours, List<String> prerequisites, String description) {
    	// Create a new courseRecord object
    	courseRecord course = new courseRecord(id, hours, prerequisites, description);
    	
    	// Check if the ID already exists
    	if(course_map.containsKey(id)) {
			throw new IllegalArgumentException("Id already exists");
		}
    	
    	// Add the course record to the HashMap
    	course_map.put(id, course);
		return;
    }
    
    // Method to update an existing course record
    public static void updateCourseRecord(String id, int hours, List<String> prerequisites, String description) {
    	// Create a new courseRecord object
    	courseRecord course = new courseRecord(id, hours, prerequisites, description);
    	
    	// Check if the ID exists
    	if(!course_map.containsKey(id)) {
			throw new IllegalArgumentException("Id doesn't exists");
		}
    	
    	// Update the course record in the HashMap
    	course_map.put(id, course);
    	return;
    }
    
    // Method to delete an existing course record
    public static void deleteCourseRecord(String id) {
    	// Check if the ID exists
    	if(!course_map.containsKey(id)) {
			throw new IllegalArgumentException("Id doesn't exists");
		}
    	
    	// Remove the course record from the HashMap
    	course_map.remove(id);
    	return;
    }
    
    // Method to get a course record by ID
    public static courseRecord getCourse(String id) {
    	// Check if the ID exists
    	if(!course_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Retrieve and return the course record from the HashMap
    	courseRecord courseRecord = course_map.get(id);
    	return courseRecord;
    }
    
    // Method to add a prerequisite to a course
    public static void addprerequisite(String id, String prerequisite) {
    	// Check if the course ID exists
    	if(!course_map.containsKey(id)) {
			throw new IllegalArgumentException("Course with ID" + id + " doesn't exists");
		}
    	
        // Retrieve the course record
        courseRecord course = course_map.get(id);
        
        // Create a new list of prerequisites
        List<String> prerequisites = new ArrayList<>(course.getPrerequisites());
    	
        // Check if the element already exists in the list
        if (!prerequisites.contains(prerequisite)) {
            // Add the element to the end of the list
        	prerequisites.add(prerequisite);
        	System.out.println("Prerequisite added successfully.");
        } else {
            System.out.println("Prerequisite " + prerequisite + " already exists.");
        }
        
        // Set the updated prerequisites list for the course
        course.setPrerequisites(prerequisites);
        course_map.put(id, course);
    }
    
    // Method to remove a prerequisite from a course
    public static void removePrerequisite(String id, String prerequisiteToRemove) {
        // Check if the course ID exists
        if (!course_map.containsKey(id)) {
            throw new IllegalArgumentException("Course with ID " + id + " doesn't exist");
        }

        // Retrieve the course record
        courseRecord course = course_map.get(id);
        
        // Create a new list of prerequisites
        List<String> prerequisites = new ArrayList<>(course.getPrerequisites());

        // Check if the prerequisite exists in the list
        if (prerequisites.contains(prerequisiteToRemove)) {
            // Remove the prerequisite from the list
            prerequisites.remove(prerequisiteToRemove);
            System.out.println("Prerequisite removed successfully.");
        } else {
            System.out.println("Prerequisite " + prerequisiteToRemove + " does not exist for course with ID " + id);
        }

        // Update the course record with the modified prerequisites list
        course.setPrerequisites(prerequisites);
        course_map.put(id, course);
    }
    
    // Method to clear all course records from memory
    public static void clearmemory() {
    	course_map.clear();
    	return;
    }
}
