/*
File: ClassTest.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    This file contains unit tests for the facetofaceClassRecord and onlineClassRecord classes.
    The tests cover various scenarios such as creating face-to-face and online class records with different attributes.

*/


package Test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import classRecords.facetofaceClassRecord;
import classRecords.onlineClassRecord;

// Define the test class
class ClassTest {
	
    // Test method to create a face-to-face class record
	@Test
	void testFaceToFaceClass() throws ParseException {
		facetofaceClassRecord classRecord = new facetofaceClassRecord("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","R105");
		assertTrue(classRecord.getId().equals("1ACS499"));
		assertTrue(classRecord.getCourseId().equals("CS499"));
		assertTrue(classRecord.getSemester().equals("Spring2024"));
		assertTrue(classRecord.getDescription().equals("CSE Capstone"));
		assertTrue(classRecord.getProfessor().equals("Brooke Goggin"));
		assertTrue(classRecord.getClassroom().equals("R105"));
	}

    // Test method to create a face-to-face class record with an ID that is too long
	@Test
	void testf2fIdTooLong() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new facetofaceClassRecord("1ACS4991232132131","CS499","Spring2024","CSE Capstone","Brooke Goggin","R105");
		});
	}
	
    // Test method to create a face-to-face class record with a null ID
	@Test
	void testf2fIdNull() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new facetofaceClassRecord(null,"CS499","Spring2024","CSE Capstone","Brooke Goggin","R105");
		});
	}
	
    // Test method to create a face-to-face class record with a description that is too long
	@Test
	void testf2fDescriptionTooLong() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new facetofaceClassRecord("1ACS499","CS499","Spring2024","CSE Capstone for the final thing to complete the course and graduate","Brooke Goggin","R105");
		});
	}
	
    // Test method to create an online class record
	@Test
	void testOnlineClass() throws ParseException {
		onlineClassRecord classRecord = new onlineClassRecord("1ACS499","CS499","Spring2024","CSE Capstone","Brooke Goggin","snhu.edu/CS499", "u34hw9i");
		assertTrue(classRecord.getId().equals("1ACS499"));
		assertTrue(classRecord.getCourseId().equals("CS499"));
		assertTrue(classRecord.getSemester().equals("Spring2024"));
		assertTrue(classRecord.getDescription().equals("CSE Capstone"));
		assertTrue(classRecord.getProfessor().equals("Brooke Goggin"));
		assertTrue(classRecord.getCourseURL().equals("snhu.edu/CS499"));
		assertTrue(classRecord.getOnlineCode().equals("u34hw9i"));
	}

    // Test method to create an online class record with an ID that is too long
	@Test
	void testOnlineIdTooLong() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new onlineClassRecord("1ACS49965464226453","CS499","Spring2024","CSE Capstone","Brooke Goggin","snhu.edu/CS499", "u34hw9i");
		});
	}
	
    // Test method to create an online class record with a null ID
	@Test
	void testOnlineIdNull() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new onlineClassRecord(null,"CS499","Spring2024","CSE Capstone","Brooke Goggin","snhu.edu/CS499", "u34hw9i");
		});
	}
	
    // Test method to create an online class record with a description that is too long
	@Test
	void testOnlineDescriptionTooLong() throws ParseException {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new onlineClassRecord("1ACS499","CS499","Spring2024","CSE Capstone for the final thing to complete the course and graduate","Brooke Goggin","snhu.edu/CS499", "u34hw9i");
		});
	}
}
