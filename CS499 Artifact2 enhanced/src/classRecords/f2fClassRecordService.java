/*
File: f2fClassRecordService.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Constructs and defines the f2fClassRecordService class.
    This class provides services for managing facetofaceClassRecord objects.

*/

// Define the package for the class
package classRecords;

// Import necessary Java utilities
import java.util.HashMap;

// Define the f2fClassRecordService class
public class f2fClassRecordService {
	
	// HashMap to store facetofaceClassRecord objects with their IDs as keys
	private static HashMap<String, facetofaceClassRecord> class_map = new HashMap<String, facetofaceClassRecord>();
	    
	// Method to add a new facetofaceClassRecord object
    public static void addClass(String id, String courseId, String semester, String description, String professor, String classroom) {
    	// Create a new facetofaceClassRecord object
    	facetofaceClassRecord classRecord = new facetofaceClassRecord(id, courseId, semester, description, professor, classroom);
    	
    	// Check if the ID already exists
    	if(class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " already exists");
		}
    	
    	// Add the facetofaceClassRecord object to the HashMap
    	class_map.put(id, classRecord);
		return;
    }
    
    // Method to delete a facetofaceClassRecord object
    public static void deleteClass(String id) {
    	// Check if the ID exists
    	if(!class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Remove the facetofaceClassRecord object from the HashMap
    	class_map.remove(id);
    	return;
    }
    
    // Method to update a facetofaceClassRecord object
    public static void updateClass(String id, String courseId, String semester, String description, String professor, String classroom) {
    	// Create a new facetofaceClassRecord object
    	facetofaceClassRecord classRecord = new facetofaceClassRecord(id, courseId, semester, description, professor, classroom);
    	
    	// Check if the ID exists
    	if(!class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Update the facetofaceClassRecord object in the HashMap
    	class_map.put(id, classRecord);
    	return;
    }
    
    // Method to get a facetofaceClassRecord object by ID
    public static facetofaceClassRecord getClass(String id) {
    	// Check if the ID exists
    	if(!class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Retrieve and return the facetofaceClassRecord object from the HashMap
    	facetofaceClassRecord classRecord = class_map.get(id);
    	return classRecord;
    }
    
    // Method to clear all facetofaceClassRecord objects from memory
    public static void clearmemory() {
    	// Clear the HashMap
    	class_map.clear();
    	return;
    }
}
