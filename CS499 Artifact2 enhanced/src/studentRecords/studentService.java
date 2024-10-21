/*
File: studentService.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Constructs and defines the studentService class.
    This class provides services for managing student objects.

*/

// Define the package for the class
package studentRecords;

// Import necessary Java utilities
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// Define the studentService class
public class studentService {
    // Create a HashMap to store student records
    private static HashMap<String, student> student_map = new HashMap<String, student>();

    // Method to add a new student record
    public static void addStudent(String id, String firstName, String lastName, String phoneNumber, String address, List<String> coursesComplete) {
        student student = new student(id, firstName, lastName, phoneNumber, address, coursesComplete);
        if (student_map.containsKey(id)) {
            throw new IllegalArgumentException("Student " + id + " already exists");
        }
        student_map.put(id, student);
        return;
    }

    // Method to update an existing student record
    public static void updateStudent(String id, String firstName, String lastName, String phoneNumber, String address, List<String> coursesComplete) {
        student student = new student(id, firstName, lastName, phoneNumber, address, coursesComplete);
        if (!student_map.containsKey(id)) {
            throw new IllegalArgumentException("Student " + id + " doesn't exists");
        }
        student_map.put(id, student);
        return;
    }

    // Method to delete a student record
    public static void deleteStudent(String id) {
        if (!student_map.containsKey(id)) {
            throw new IllegalArgumentException("Student " + id + " doesn't exists");
        }
        student_map.remove(id);
        return;
    }

    // Method to retrieve a student record by ID
    public static student getStudent(String id) {
        if (!student_map.containsKey(id)) {
            throw new IllegalArgumentException("Id " + id + " doesn't exists");
        }
        student studentRecord = student_map.get(id);
        return studentRecord;
    }

    // Method to add completed courses for a student
    public static void addCoursesComplete(String id, String course) {
        if (!student_map.containsKey(id)) {
            throw new IllegalArgumentException("Student with ID" + id + " doesn't exists");
        }
        student student = student_map.get(id);
        List<String> courses = new ArrayList<>(student.getCoursesComplete());

        // Check if the course already exists in the list
        if (!courses.contains(course)) {
            // Add the course to the end of the list
            courses.add(course);
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Course " + course + " already exists.");
        }
        student.setCoursesComplete(courses);
        student_map.put(id, student);
    }

    // Method to remove completed courses for a student
    public static void removeCoursesComplete(String id, String courseToRemove) {
        if (!student_map.containsKey(id)) {
            throw new IllegalArgumentException("Student with ID " + id + " doesn't exist");
        }

        student student = student_map.get(id);
        List<String> courses = new ArrayList<>(student.getCoursesComplete());

        // Check if the course exists in the list
        if (courses.contains(courseToRemove)) {
            // Remove the course from the list
            courses.remove(courseToRemove);
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course " + courseToRemove + " does not exist for student with ID " + id);
        }

        // Update the student record with the modified courses list
        student.setCoursesComplete(courses);
        student_map.put(id, student);
    }

    // Method to clear the student records
    public static void clearmemory() {
        student_map.clear();
        return;
    }

}
