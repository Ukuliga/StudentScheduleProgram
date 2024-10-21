/*
File: StudentServiceTest.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description:
    This file contains unit tests for the StudentService class.
    
*/

package Test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import studentRecords.studentService;


class StudentServiceTest {
	
	@BeforeEach
	void setup() {
		studentService.clearmemory(); // Clearing memory before each test
	}
	
	@Test
	void testaddStudent() throws ParseException {
		// Adding a student and checking if the operation is successful
		List<String> coursesComplete = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
        }};
        studentService.addStudent("Steph01","Paul", "Stephan","5134352820","1323 Avon Dr. Cincinnati, OH", coursesComplete);
		assertTrue(true);
	}
	
	@Test
	void testaddStudentIdAlreadyExists() throws ParseException {
		// Adding a student with an existing ID, expects an IllegalArgumentException
		List<String> coursesComplete = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
        }};
        studentService.addStudent("Steph01","Paul", "Stephan","5134352820","1323 Avon Dr. Cincinnati, OH", coursesComplete);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			studentService.addStudent("Steph01","Paul", "Stephan","5134352820","1323 Avon Dr. Cincinnati, OH", coursesComplete);
			});
	}
	
	@Test
	void testDeleteStudent() throws ParseException {
		// Adding a student and then deleting them
		List<String> coursesComplete = new ArrayList<String>() {{
			add("CS315");
            add("IT210");
        }};
        studentService.addStudent("Steph01","Paul", "Stephan","5134352820","1323 Avon Dr. Cincinnati, OH", coursesComplete);
        studentService.deleteStudent("Steph01");
		assertTrue(true);
	}
	
	@Test
	void testdeleteStudentdoesntExist() throws ParseException {
		// Attempting to delete a student that doesn't exist, expects an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			studentService.deleteStudent("Steph01");
		});
	}
	
	@Test
	void testupdateStudent() throws ParseException {
		// Adding a student and then updating their information
		List<String> coursesComplete = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
        }};
        studentService.addStudent("Steph01","Paul", "Stephan","5134352820","1323 Avon Dr. Cincinnati, OH", coursesComplete);
        studentService.updateStudent("Steph01","Paul", "Stephan","5134352820","4611 Kedzie Ave. Chicago, IL", coursesComplete);
		assertTrue(studentService.getStudent("Steph01").getAddress().equals("4611 Kedzie Ave. Chicago, IL"));
	}
	
	@Test
	void testupdateStudentDoesntExist() throws ParseException {
		// Attempting to update information of a student that doesn't exist, expects an IllegalArgumentException
		List<String> coursesComplete = new ArrayList<String>() {{
            add("CS315");
            add("IT210");

        }};
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			studentService.updateStudent("Steph01","Paul", "Stephan","5134352820","4611 Kedzie Ave. Chicago, IL", coursesComplete);
		});
	}
	
	@Test
	void testAddCoursesRequired() throws ParseException {
		// Adding a student and then adding additional completed courses
		List<String> coursesComplete = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
        }};
        studentService.addStudent("Steph01","Paul", "Stephan","5134352820","1323 Avon Dr. Cincinnati, OH", coursesComplete);
        studentService.addCoursesComplete("Steph01", "DAT220" );
        coursesComplete.add("DAT220");
		assertTrue(studentService.getStudent("Steph01").getCoursesComplete().equals(coursesComplete));
	}
	
	@Test
	void testDropCoursesRequired() throws ParseException {
		// Adding a student and then removing completed courses
		List<String> coursesComplete = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
        }};
        studentService.addStudent("Steph01","Paul", "Stephan","5134352820","1323 Avon Dr. Cincinnati, OH", coursesComplete);
        studentService.removeCoursesComplete("Steph01", "IT210" );
        coursesComplete.remove("IT210");
		assertTrue(studentService.getStudent("Steph01").getCoursesComplete().equals(coursesComplete));
	}

}
