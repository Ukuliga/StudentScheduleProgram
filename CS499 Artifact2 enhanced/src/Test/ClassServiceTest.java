/*
File: ClassServiceTest.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    This file contains unit tests for the classRecordService class.
    The tests cover various scenarios such as adding, deleting, and updating class records.

*/


package Test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classRecords.classRecordService;

// Define the test class
class ClassServiceTest {
	
    // Method to set up the test environment before each test method
	@BeforeEach
	void setup() {
		classRecordService.clearmemory();
	}
	
	// Test method to add a class record
	@Test
	void testaddClass() throws ParseException {
		classRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin" );
		assertTrue(true);
	}
	
	// Test method to add a class record when the ID already exists
	@Test
	void testaddClassIdAlreadyExists() throws ParseException {
		classRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			classRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin" );
		});
	}
	
	// Test method to delete a class record
	@Test
	void testDeleteClass() throws ParseException {
		classRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin" );
		classRecordService.deleteClass("1ACS499");
		assertTrue(true);
	}
	
	// Test method to delete a class record that doesn't exist
	@Test
	void testdeleteClassdoesntExist() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			classRecordService.deleteClass("12345");
		});
	}
	
	// Test method to update a class record
	@Test
	void testupdateClass() throws ParseException {
		classRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin" );
		classRecordService.updateClass("1ACS499","CS499","Summer2024","CSE Capstone","Brooke Goggin" );
		assertTrue(classRecordService.getClass("1ACS499").getSemester().equals("Summer2024"));
	}
	
	// Test method to update a class record that doesn't exist
	@Test
	void testupdateClassDoesntExist() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			classRecordService.updateClass("1ACS499","CS499","Summer2024","CSE Capstone","Brooke Goggin" );
		});
	}
}
