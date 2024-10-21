/*
File: classRecordService.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Service for classRecord to implement using the classRecord class
*/

// Declare the package for the class
package classRecords;

// Import necessary Java utilities
import java.util.HashMap;

// Define the classRecordService class
public class classRecordService {
	
	// HashMap to store class records with their IDs as keys
	private static HashMap<String, classRecord> class_map = new HashMap<String, classRecord>();
	    
	// Method to add a new class record
    public static void addClass(String id, String courseId, String semester, String description, String professor) {
    	// Create a new classRecord object
    	classRecord classRecord = new classRecord(id, courseId, semester, description, professor);
    	
    	// Check if the ID already exists
    	if(class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " already exists");
		}
    	
    	// Add the class record to the HashMap
    	class_map.put(id, classRecord);
		return;
    }
    
    // Method to delete a class record
    public static void deleteClass(String id) {
    	// Check if the ID exists
    	if(!class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Remove the class record from the HashMap
    	class_map.remove(id);
    	return;
    }
    
    // Method to update a class record
    public static void updateClass(String id, String courseId, String semester, String description, String professor) {
    	// Create a new classRecord object
    	classRecord classRecord = new classRecord(id, courseId, semester, description, professor);
    	
    	// Check if the ID exists
    	if(!class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Update the class record in the HashMap
    	class_map.put(id, classRecord);
    	return;
    }
    
    // Method to get a class record by ID
    public static classRecord getClass(String id) {
    	// Check if the ID exists
    	if(!class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Retrieve and return the class record from the HashMap
    	classRecord classRecord = class_map.get(id);
    	return classRecord;
    }
    
    // Method to clear all class records from memory
    public static void clearmemory() {
    	// Clear the HashMap
    	class_map.clear();
    	return;
    }
}
