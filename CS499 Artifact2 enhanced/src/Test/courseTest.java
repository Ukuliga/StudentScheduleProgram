/*
File: CourseTest.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    This file contains unit tests for the courseRecord class.
    The tests cover various scenarios such as creating course records with different attributes.

*/


package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import courseRecords.courseRecord;

// Define the test class
class CourseTest {
	
	
	// Test method to create a course record
	@Test
	void testCourse() throws ParseException {
		List<String> prerequisites = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
		courseRecord courseRecord = new courseRecord("CS499",4, prerequisites, "CSE Capstone");
		assertTrue(courseRecord.getId().equals("CS499"));
		assertEquals(4, courseRecord.getHours());
		assertTrue(courseRecord.getPrerequisites().equals(prerequisites));
		assertTrue(courseRecord.getDescription().equals("CSE Capstone"));

	}

	// Test method to create a course record with an ID that is too long
	@Test
	void testIdTooLong() throws ParseException {
		List<String> prerequisites = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new courseRecord("CS49923423435376",4, prerequisites, "CSE Capstone");
		});
	}
	
	// Test method to create a course record with a null ID
	@Test
	void testIdNull() throws ParseException {
		List<String> prerequisites = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new courseRecord(null ,4, prerequisites, "CSE Capstone");
		});
	}
	
	// Test method to create a course record with a description that is too long
	@Test
	void testDescriptionTooLong() throws ParseException {
		List<String> prerequisites = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new courseRecord("CS499" ,4, prerequisites, "CSE Capstone for the final thing to complete the course and graduate");
		});
	}
	
	

}
