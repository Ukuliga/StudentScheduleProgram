/*
File: programTest.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description:
    This file contains unit tests for the program class.
    The tests cover various scenarios such as creating program records with different attributes.

*/

package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programRecords.program;

// Define the test class
class programTest {
    
    // Test method to create a program record
    @Test
    void testProgram() throws ParseException {
        List<String> coursesRequired = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
        program programRecord = new program("CSE" ,coursesRequired, 120,"Bachelor's of Science");
        assertTrue(programRecord.getId().equals("CSE"));
        assertEquals(120, programRecord.getHoursRequired());
        assertTrue(programRecord.getCoursesRequired().equals(coursesRequired));
        assertTrue(programRecord.getDegreeType().equals("Bachelor's of Science"));
    }

    // Test method to check if the ID length is too long
    @Test
    void testIdTooLong() throws ParseException {
        List<String> coursesRequired = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new program("CS49923423435376",coursesRequired, 120,"Bachelor's of Science");
            });
    }
    
    // Test method to check if the ID is null
    @Test
    void testIdNull() throws ParseException {
        List<String> coursesRequired = new ArrayList<String>() {{
            add("CS315");
            add("IT210");
            add("CS350");
        }};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new program(null,coursesRequired, 120,"Bachelor's of Science");
            });
    }
}
