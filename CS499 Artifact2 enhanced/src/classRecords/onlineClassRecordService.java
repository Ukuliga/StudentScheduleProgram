/*
File: onlineClassRecordService.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Constructs and defines the onlineClassRecordService class.
    This class provides services for managing onlineClassRecord objects.

*/

// Define the package for the class
package classRecords;

// Import necessary Java utilities
import java.util.HashMap;

// Define the onlineClassRecordService class
public class onlineClassRecordService {
	
	// HashMap to store onlineClassRecord objects with their IDs as keys
	private static HashMap<String, onlineClassRecord> class_map = new HashMap<String, onlineClassRecord>();
	    
	// Method to add a new onlineClassRecord object
    public static void addClass(String id, String courseId, String semester, String description, String professor, String courseURL, String onlineCode) {
    	// Create a new onlineClassRecord object
    	onlineClassRecord classRecord = new onlineClassRecord(id, courseId, semester, description, professor, courseURL, onlineCode);
    	
    	// Check if the ID already exists
    	if(class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " already exists");
		}
    	
    	// Add the onlineClassRecord object to the HashMap
    	class_map.put(id, classRecord);
		return;
    }
    
    // Method to delete an onlineClassRecord object
    public static void deleteClass(String id) {
    	// Check if the ID exists
    	if(!class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Remove the onlineClassRecord object from the HashMap
    	class_map.remove(id);
    	return;
    }
    
    // Method to update an onlineClassRecord object
    public static void updateClass(String id, String courseId, String semester, String description, String professor, String courseURL, String onlineCode) {
    	// Create a new onlineClassRecord object
    	onlineClassRecord classRecord = new onlineClassRecord(id, courseId, semester, description, professor, courseURL, onlineCode);
    	
    	// Check if the ID exists
    	if(!class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Update the onlineClassRecord object in the HashMap
    	class_map.put(id, classRecord);
    	return;
    }
    
    // Method to get an onlineClassRecord object by ID
    public static onlineClassRecord getClass(String id) {
    	// Check if the ID exists
    	if(!class_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Retrieve and return the onlineClassRecord object from the HashMap
    	onlineClassRecord classRecord = class_map.get(id);
    	return classRecord;
    }
    
    // Method to clear all onlineClassRecord objects from memory
    public static void clearmemory() {
    	// Clear the HashMap
    	class_map.clear();
    	return;
    }
}
