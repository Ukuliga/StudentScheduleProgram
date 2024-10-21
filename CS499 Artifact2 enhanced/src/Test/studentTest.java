/*
File: studenteTest.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description:
    This file contains unit tests for the Student class.
    
*/

package Test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studentRecords.student;


class studentTest {
	
	
	@Test
	void testProgram() throws ParseException {
		// Setting up courses completed by the student
		List<String> coursesComplete = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
        // Creating a new student
        student student = new student("Steph01","Paul", "Stephan","5134352820","1323 Avon Dr. Cincinnati, OH", coursesComplete);
		// Assertions to verify student information
		assertTrue(student.getId().equals("Steph01"));
		assertTrue(student.getFirstName().equals("Paul"));
		assertTrue(student.getLastName().equals("Stephan"));
		assertTrue(student.getPhoneNumber().equals("5134352820"));
		assertTrue(student.getAddress().equals("1323 Avon Dr. Cincinnati, OH"));
		assertTrue(student.getCoursesComplete().equals(coursesComplete));

	}

	@Test
	void testIdTooLong() throws ParseException {
		// Setting up courses completed by the student
		List<String> coursesComplete = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
		// Creating a student with an ID that's too long, expects an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new student("Jachthuber2373271","Paul", "Stephan","5134352820","1323 Avon Dr. Cincinnati, OH", coursesComplete);
			});
	}
	
	@Test
	void testIdNull() throws ParseException {
		// Setting up courses completed by the student
		List<String> coursesComplete = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
		// Creating a student with a null ID, expects an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new student(null,"Paul", "Stephan","5134352820","1323 Avon Dr. Cincinnati, OH", coursesComplete);
			});
	}

	
	

}
