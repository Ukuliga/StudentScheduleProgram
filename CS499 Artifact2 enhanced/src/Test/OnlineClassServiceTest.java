/*
File: OnlineClassServiceTest.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    This file contains unit tests for the onlineClassRecordService class.
    The tests cover various scenarios such as adding, deleting, and updating online class records.

*/

package Test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classRecords.onlineClassRecordService;

// Define the test class
class OnlineClassServiceTest {
	
	// Setup method to clear memory before each test
	@BeforeEach
	void setup() {
		onlineClassRecordService.clearmemory();
	}
	
	// Test method to add an online class record
	@Test
	void testaddOnlineClass() throws ParseException {
		onlineClassRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","snhu.edu/CS499", "u34hw9i" );
		assertTrue(true);
	}
	
	// Test method to add an online class record with an ID that already exists
	@Test
	void testaddOnlineClassIdAlreadyExists() throws ParseException {
		onlineClassRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","snhu.edu/CS499", "u34hw9i");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			onlineClassRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","snhu.edu/CS499", "u34hw9i" );
			});
	}
	
	// Test method to delete an online class record
	@Test
	void testDeleteOnlineClass() throws ParseException {
		onlineClassRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","snhu.edu/CS499", "u34hw9i" );
		onlineClassRecordService.deleteClass("1ACS499");
		assertTrue(true);
	}
	
	// Test method to delete an online class record that doesn't exist
	@Test
	void testdeleteOnlineClassdoesntExist() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			onlineClassRecordService.deleteClass("12345");
		});
	}
	
	// Test method to update an online class record
	@Test
	void testupdateOnlineClass() throws ParseException {
		onlineClassRecordService.addClass("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","snhu.edu/CS499", "u34hw9i" );
		onlineClassRecordService.updateClass("1ACS499","CS499","Summer2024","CSE Capstone","Brooke Goggin","snhu.edu/CS499", "u34hw9i" );
		assertTrue(onlineClassRecordService.getClass("1ACS499").getSemester().equals("Summer2024"));
	}
	
	// Test method to update an online class record that doesn't exist
	@Test
	void testupdateOnlineClassDoesntExist() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			onlineClassRecordService.updateClass("1ACS499","CS499","Summer2024","CSE Capstone","Brooke Goggin","snhu.edu/CS499", "u34hw9i" );
		});
	}
	

}
