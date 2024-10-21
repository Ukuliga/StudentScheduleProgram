/*
File: CourseServiceTest.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    This file contains unit tests for the courseRecordService class.
    The tests cover various scenarios such as adding, deleting, updating, adding prerequisites, and dropping prerequisites for course records.

*/


package Test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import courseRecords.courseRecordService;

// Define the test class
class CourseServiceTest {
	
	// Method to set up the test environment before each test case
	@BeforeEach
	void setup() {
		courseRecordService.clearmemory();
	}
	
	// Test method to add a course
	@Test
	void testaddCourse() throws ParseException {
		List<String> prerequisites = new ArrayList<String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
		courseRecordService.addCourse("CS499",4, prerequisites, "CSE Capstone" );
		assertTrue(true);
	}
	
	// Test method to add a course with an ID that already exists
	@Test
	void testaddCourseIdAlreadyExists() throws ParseException {
		List<String> prerequisites = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
		courseRecordService.addCourse("CS499",4, prerequisites, "CSE Capstone" );
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			courseRecordService.addCourse("CS499",4, prerequisites, "CSE Capstone" );
			});
	}
	
	// Test method to delete a course
	@Test
	void testDeleteCourse() throws ParseException {
		List<String> prerequisites = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
        courseRecordService.addCourse("CS499",4, prerequisites, "CSE Capstone" );
        courseRecordService.deleteCourseRecord("CS499");
		assertTrue(true);
	}
	
	// Test method to delete a course that doesn't exist
	@Test
	void testdeleteCoursedoesntExist() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			courseRecordService.deleteCourseRecord("CS499");
		});
	}
	
	// Test method to update a course
	@Test
	void testupdateCourse() throws ParseException {
		List<String> prerequisites = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
        courseRecordService.addCourse("CS499",4, prerequisites, "CSE Capstone" );
        courseRecordService.updateCourseRecord("CS499",4, prerequisites, "CSE Capstone Class" );
		assertTrue(courseRecordService.getCourse("CS499").getDescription().equals("CSE Capstone Class"));
	}
	
	// Test method to update a course that doesn't exist
	@Test
	void testupdateCourseDoesntExist() throws ParseException {
		List<String> prerequisites = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			courseRecordService.updateCourseRecord("CS499",4, prerequisites, "CSE Capstone Class" );
		});
	}
	
	// Test method to add a prerequisite to a course
	@Test
	void testAddPrerequisite() throws ParseException {
		List<String> prerequisites = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
        courseRecordService.addCourse("CS499",4, prerequisites, "CSE Capstone" );
        courseRecordService.addprerequisite("CS499", "DAT220" );
        prerequisites.add("DAT220");
		assertTrue(courseRecordService.getCourse("CS499").getPrerequisites().equals(prerequisites));
	}
	
	// Test method to drop a prerequisite from a course
	@Test
	void testDropPrerequisite() throws ParseException {
		List<String> prerequisites = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
        courseRecordService.addCourse("CS499",4, prerequisites, "CSE Capstone" );
        courseRecordService.removePrerequisite("CS499", "CS350" );
        prerequisites.remove("CS350");
		assertTrue(courseRecordService.getCourse("CS499").getPrerequisites().equals(prerequisites));
	}
}
