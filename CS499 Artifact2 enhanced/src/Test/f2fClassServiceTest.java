/*
File: f2fClassServiceTest.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    This file contains unit tests for the f2fClassRecordService class.
    The tests cover various scenarios such as adding, deleting, and updating face-to-face class records.

*/

package Test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import classRecords.f2fClassRecordService;

// Define the test class
class f2fClassServiceTest {
	
	
	// Setup method to clear memory before each test
	@BeforeEach
	void setup() {
		f2fClassRecordService.clearmemory();
	}
	
	// Test method to add a face-to-face class record
	@Test
	void testaddf2fClass() throws ParseException {
		f2fClassRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","R105" );
		assertTrue(true);
	}
	
	// Test method to add a face-to-face class record with an ID that already exists
	@Test
	void testaddf2fClassIdAlreadyExists() throws ParseException {
		f2fClassRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","R105");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f2fClassRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","R105" );
			});
	}
	
	// Test method to delete a face-to-face class record
	@Test
	void testDeletef2fClass() throws ParseException {
		f2fClassRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","R105" );
		f2fClassRecordService.deleteClass("1ACS499");
		assertTrue(true);
	}
	
	// Test method to delete a face-to-face class record that doesn't exist
	@Test
	void testdeletef2fClassdoesntExist() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f2fClassRecordService.deleteClass("12345");
		});
	}
	
	// Test method to update a face-to-face class record
	@Test
	void testupdatef2fClass() throws ParseException {
		f2fClassRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","R105" );
		f2fClassRecordService.updateClass("1ACS499","CS499","Summer2024","CSE Capstone","Brooke Goggin","R105" );
		assertTrue(f2fClassRecordService.getClass("1ACS499").getSemester().equals("Summer2024"));
	}
	
	// Test method to update a face-to-face class record that doesn't exist
	@Test
	void testupdatef2fClassDoesntExist() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f2fClassRecordService.updateClass("1ACS499","CS499","Summer2024","CSE Capstone","Brooke Goggin","R105" );
		});
	}
	

}
