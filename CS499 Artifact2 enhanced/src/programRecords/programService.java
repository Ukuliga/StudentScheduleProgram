/*
File: programService.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Constructs and defines the programService class.
    This class provides services for managing program objects.

*/

// Define the package for the class
package programRecords;

// Import necessary Java utilities
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// Define the programService class
public class programService {
	// Create a HashMap to store program records
    private static HashMap<String, program> program_map = new HashMap<String, program>();
    
    // Method to add a new program record
    public static void addProgram(String id, List<String> coursesRequired, int hoursRequired, String degreeType) {
    	// Create a new program object
    	program program = new program(id, coursesRequired, hoursRequired, degreeType);
    	
    	// Check if the ID already exists
    	if(program_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " already exists");
		}
    	
    	// Add the program record to the HashMap
    	program_map.put(id, program);
		return;
    }
    
    // Method to update an existing program record
    public static void updateProgram(String id, List<String> coursesRequired, int hoursRequired, String degreeType) {
    	// Create a new program object
    	program program = new program(id, coursesRequired, hoursRequired, degreeType);
    	
    	// Check if the ID exists
    	if(!program_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Update the program record in the HashMap
    	program_map.put(id, program);
    	return;
    }
    
    // Method to delete an existing program record
    public static void deleteProgram(String id) {
    	// Check if the ID exists
    	if(!program_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Remove the program record from the HashMap
    	program_map.remove(id);
    	return;
    }
    
    // Method to get a program record by ID
    public static program getProgram(String id) {
    	// Check if the ID exists
    	if(!program_map.containsKey(id)) {
			throw new IllegalArgumentException("Id " + id + " doesn't exists");
		}
    	
    	// Retrieve and return the program record from the HashMap
    	program programRecord = program_map.get(id);
    	return programRecord;
    }
    
    // Method to add a required course to a program
    public static void addCoursesRequired(String id, String course) {
    	// Check if the program ID exists
    	if(!program_map.containsKey(id)) {
			throw new IllegalArgumentException("Program with ID" + id + " doesn't exists");
		}
    	
    	// Retrieve the program record
    	program program = program_map.get(id);
    	
        // Create a new list of courses required
        List<String> courses = new ArrayList<>(program.getCoursesRequired());
    	
        // Check if the course already exists in the list
        if (!courses.contains(course)) {
            // Add the course to the end of the list
        	courses.add(course);
        	System.out.println("Course added successfully.");
        } else {
            System.out.println("course " + course + " already exists.");
        }
        
        // Set the updated courses list for the program
        program.setCoursesRequired(courses);
        program_map.put(id, program);
    }
    
    // Method to remove a required course from a program
    public static void removeCoursesRequired(String id, String courseToRemove) {
        // Check if the program ID exists
        if (!program_map.containsKey(id)) {
            throw new IllegalArgumentException("Program with ID " + id + " doesn't exist");
        }

        // Retrieve the program record
        program program = program_map.get(id);
        List<String> courses = new ArrayList<>(program.getCoursesRequired());

        // Check if the course exists in the list
        if (courses.contains(courseToRemove)) {
            // Remove the course from the list
        	courses.remove(courseToRemove);
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course " + courseToRemove + " does not exist for course with ID " + id);
        }

        // Update the program record with the modified courses list
        program.setCoursesRequired(courses);
        program_map.put(id, program);
    }
    
    // Method to retrieve all programs
    public static List<program> getAllPrograms() {
        return new ArrayList<>(program_map.values());
    }
    
    // Method to clear all program records from memory
    public static void clearmemory() {
    	program_map.clear();
    	return;
    }

}
