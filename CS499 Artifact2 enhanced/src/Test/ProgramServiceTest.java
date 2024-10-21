/*
File: ProgramServiceTest.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    This file contains unit tests for the programService class.
    The tests cover various scenarios such as adding, deleting, updating, adding required courses, and dropping required courses for program records.

*/

package Test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import programRecords.programService;

// Define the test class
class ProgramServiceTest {
	
	// Setup method to clear memory before each test
	@BeforeEach
	void setup() {
		programService.clearmemory();
	}
	
	// Test method to add a program record
	@Test
	void testaddProgram() throws ParseException {
		List<String> coursesRequired = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
            add("CS499");
        }};
        programService.addProgram("CSE" ,coursesRequired, 120,"Bachelor's of Science");
		assertTrue(true);
	}
	
	// Test method to add a program record with an ID that already exists
	@Test
	void testaddCourseIdAlreadyExists() throws ParseException {
		List<String> coursesRequired = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
            add("CS499");
        }};
        programService.addProgram("CSE" ,coursesRequired, 120,"Bachelor's of Science");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			programService.addProgram("CSE" ,coursesRequired, 120,"Bachelor's of Science");
			});
	}
	
	// Test method to delete a program record
	@Test
	void testDeleteCourse() throws ParseException {
		List<String> coursesRequired = new ArrayList<String>() {{
			add("CS315");
            add("IT210");
            add("CS350");
            add("CS499");
        }};
        programService.addProgram("CSE" ,coursesRequired, 120,"Bachelor's of Science");
        programService.deleteProgram("CSE");
		assertTrue(true);
	}
	
	// Test method to delete a program record that doesn't exist
	@Test
	void testdeleteCoursedoesntExist() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			programService.deleteProgram("CSE");
		});
	}
	
	// Test method to update a program record
	@Test
	void testupdateCourse() throws ParseException {
		List<String> coursesRequired = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
            add("CS499");
        }};
        programService.addProgram("CSE" ,coursesRequired, 120,"Bachelor's of Science");
        programService.updateProgram("CSE" ,coursesRequired, 120,"Bachelor's of Science Degree");
		assertTrue(programService.getProgram("CSE").getDegreeType().equals("Bachelor's of Science Degree"));
	}
	
	// Test method to update a program record that doesn't exist
	@Test
	void testupdateCourseDoesntExist() throws ParseException {
		List<String> coursesRequired = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
            add("CS499");
        }};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			programService.updateProgram("CSE" ,coursesRequired, 120,"Bachelor's of Science");
		});
	}
	
	// Test method to add required courses to a program
	@Test
	void testAddCoursesRequired() throws ParseException {
		List<String> coursesRequired = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
            add("CS499");
        }};
        programService.addProgram("CSE" ,coursesRequired, 120,"Bachelor's of Science");
        programService.addCoursesRequired("CSE", "DAT220" );
        coursesRequired.add("DAT220");
		assertTrue(programService.getProgram("CSE").getCoursesRequired().equals(coursesRequired));
	}
	
	// Test method to drop required courses from a program
	@Test
	void testDropCoursesRequired() throws ParseException {
		List<String> coursesRequired = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
            add("CS499");
        }};
        programService.addProgram("CSE" ,coursesRequired, 120,"Bachelor's of Science");
        programService.removeCoursesRequired("CSE", "CS350" );
        coursesRequired.remove("CS350");
		assertTrue(programService.getProgram("CSE").getCoursesRequired().equals(coursesRequired));
	}

}
