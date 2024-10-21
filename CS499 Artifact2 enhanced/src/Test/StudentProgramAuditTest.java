/*
File: StudentProgramAuditTest.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description:
    This file contains unit tests for the StudentProgramAudit class.
    The tests help students understand their position in a program and the possible programs they can apply for.

*/

package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import courseRecords.courseRecordService;
import studentRecords.student;
import studentRecords.studentService;
import programRecords.program;
import programRecords.programService;

class StudentProgramAuditTest {
    
    @BeforeEach
    void setup() {
        studentService.clearmemory();
        programService.clearmemory();
        courseRecordService.clearmemory();
    }
    
    @Test
    void testStudentProgramAudit() throws ParseException {
        // Define prerequisite courses for various subjects
        List<String> noPrereq = new ArrayList<String>() {{}};
        List<String> cs315Prereq = new ArrayList<String>() {{ add("IT210"); }};
        List<String> it210Prereq = new ArrayList<String>() {{}};
        List<String> cs350Prereq = new ArrayList<String>() {{ add("CS315"); add("IT210"); }};
        List<String> cs499Prereq = new ArrayList<String>() {{ add("CS315"); add("IT210"); add("CS350"); }};
        
        // Add sample courses to the course record service
        courseRecordService.addCourse("CS315", 5, cs315Prereq, "Java Course");
        courseRecordService.addCourse("IT210", 3, it210Prereq, "Databases");
        courseRecordService.addCourse("CS350", 4, cs350Prereq, "Diagrams");
        courseRecordService.addCourse("CS499", 4, cs499Prereq, "CSE Capstone");
        courseRecordService.addCourse("EE101", 4, noPrereq, "EE first class");
        courseRecordService.addCourse("EE201", 6, noPrereq, "EE second class");
        courseRecordService.addCourse("EE301", 3, noPrereq, "EE third class");
        courseRecordService.addCourse("ENG101", 4, noPrereq, "English");
        courseRecordService.addCourse("MAT240", 4, noPrereq, "Math");
        
        // Define completed courses for a sample student
        List<String> coursesComplete = new ArrayList<String>() {{ add("CS315"); add("IT210"); add("ENG101"); add("MAT240"); add("EE101"); }};
        studentService.addStudent("Steph01", "Paul", "Stephan", "5134352820", "1323 Avon Dr. Cincinnati, OH", coursesComplete);
        
        // Define required courses for various programs
        List<String> CSEcoursesRequired = new ArrayList<String>() {{ add("CS315"); add("IT210"); add("CS350"); add("CS499"); }};
        programService.addProgram("CSE", CSEcoursesRequired, 120, "Bachelor's of Science");
        
        List<String> EEcoursesRequired = new ArrayList<String>() {{ add("EE101"); add("EE201"); add("EE301"); }};
        programService.addProgram("EE", EEcoursesRequired, 100, "Bachelor's of Engineering");
        
        // Retrieve the student object
        student student = studentService.getStudent("Steph01");
        assertNotNull(student);
        
        List<program> programsComplete = new ArrayList<>(); // Track programs that have all requirements met
        
        // Initialize variables to find the best program for the student
        program bestProgram = null;
        List<String> bestProgramMissingCourses = null;
        int bestProgramHourDifference = 0;
        double bestScore = Double.POSITIVE_INFINITY;
        
        // Iterate through each program and evaluate its suitability for the student
        List<program> programs = programService.getAllPrograms();
        for (program program : programs) {
        	
        	// Find course info between student and program
            List<String> missingCourses = new ArrayList<>(program.getCoursesRequired());
            missingCourses.removeAll(student.getCoursesComplete());
            List<String> extraCourses = new ArrayList<>(student.getCoursesComplete());
            extraCourses.removeAll(program.getCoursesRequired());

            int totalHoursCompleted = 0;
            int totalHoursRequired = program.getHoursRequired();
            
            for (String courseId : student.getCoursesComplete()) {
                totalHoursCompleted += courseRecordService.getCourse(courseId).getHours();
            }
            
            // Calculate the hour difference considering only non-negative values
            int hourDifference = Math.max(totalHoursRequired - totalHoursCompleted, 0);
            
            // Calculate the score based on missing courses and hour difference
            double score = missingCourses.size() * 5 + hourDifference;
            
            // Update the list of programs with a score of 0
            if (score == 0) {
            	programsComplete.add(program);
            }
            
            // Update the best program if the current score is better
            if (score < bestScore) {
                bestProgram = program;
                bestProgramMissingCourses = missingCourses;
                bestProgramHourDifference = hourDifference;
                bestScore = score;
            }
            
            System.out.println(program.getId());
            System.out.println("Score: " + score);
            System.out.println("Missing Courses: " + missingCourses);
            System.out.println("Extra Courses: " + extraCourses);
            System.out.println("Hour Difference: " + hourDifference);
            System.out.println("---------------------");
        }
        
        // If a student meets the requirements for a program it is displayed here, if not it shows the program they are closest to.
        if (bestScore == 0) {
        	System.out.println("Programs that are complete:");
        	for (program program : programsComplete) {
        	    System.out.println("Program ID: " + program.getId());
        	    System.out.println("Degree Type: " + program.getDegreeType());
        	    System.out.println("---------------------");
        	}
        } else {
        	// Output the best program and its details
            System.out.println("The best program available is : " + bestProgram.getId());
            System.out.println("Missing Courses: " + bestProgramMissingCourses);
            System.out.println("Hour Difference: " + bestProgramHourDifference);
            System.out.println("---------------------");
        }
        
        
    }
    
    @Test
    void testStudentProgramAuditCompleteDegree() throws ParseException {
        // Define prerequisite courses for various subjects
        List<String> noPrereq = new ArrayList<String>() {{}};
        List<String> cs315Prereq = new ArrayList<String>() {{ add("IT210"); }};
        List<String> it210Prereq = new ArrayList<String>() {{}};
        List<String> cs350Prereq = new ArrayList<String>() {{ add("CS315"); add("IT210"); }};
        List<String> cs499Prereq = new ArrayList<String>() {{ add("CS315"); add("IT210"); add("CS350"); }};
        
        // Add sample courses to the course record service
        courseRecordService.addCourse("CS315", 5, cs315Prereq, "Java Course");
        courseRecordService.addCourse("IT210", 3, it210Prereq, "Databases");
        courseRecordService.addCourse("CS350", 4, cs350Prereq, "Diagrams");
        courseRecordService.addCourse("CS499", 4, cs499Prereq, "CSE Capstone");
        courseRecordService.addCourse("EE101", 4, noPrereq, "EE first class");
        courseRecordService.addCourse("EE201", 6, noPrereq, "EE second class");
        courseRecordService.addCourse("EE301", 3, noPrereq, "EE third class");
        courseRecordService.addCourse("ENG101", 4, noPrereq, "English");
        courseRecordService.addCourse("MAT240", 4, noPrereq, "Math");
        
        // Define completed courses for a sample student
        List<String> coursesComplete = new ArrayList<String>() {{ add("CS315"); add("IT210"); add("ENG101"); add("MAT240"); add("EE101"); add("EE201"); add("EE301"); }};
        studentService.addStudent("Steph01", "Paul", "Stephan", "5134352820", "1323 Avon Dr. Cincinnati, OH", coursesComplete);
        
        // Define required courses for various programs
        List<String> CSEcoursesRequired = new ArrayList<String>() {{ add("CS315"); add("IT210"); add("CS350"); add("CS499"); }};
        programService.addProgram("CSE", CSEcoursesRequired, 120, "Bachelor's of Science");
        
        List<String> EEcoursesRequired = new ArrayList<String>() {{ add("EE101"); add("EE201"); add("EE301"); }};
        programService.addProgram("EE", EEcoursesRequired, 25, "Bachelor's of Engineering");
        
        // Retrieve the student object
        student student = studentService.getStudent("Steph01");
        assertNotNull(student);
        
        List<program> programsComplete = new ArrayList<>(); // Track programs that have all requirements met
        
        // Initialize variables to find the best program for the student
        program bestProgram = null;
        List<String> bestProgramMissingCourses = null;
        int bestProgramHourDifference = 0;
        double bestScore = Double.POSITIVE_INFINITY;
        
        // Iterate through each program and evaluate its suitability for the student
        List<program> programs = programService.getAllPrograms();
        for (program program : programs) {
        	
        	// Find course info between student and program
            List<String> missingCourses = new ArrayList<>(program.getCoursesRequired());
            missingCourses.removeAll(student.getCoursesComplete());
            List<String> extraCourses = new ArrayList<>(student.getCoursesComplete());
            extraCourses.removeAll(program.getCoursesRequired());

            int totalHoursCompleted = 0;
            int totalHoursRequired = program.getHoursRequired();
            
            for (String courseId : student.getCoursesComplete()) {
                totalHoursCompleted += courseRecordService.getCourse(courseId).getHours();
            }
            
            // Calculate the hour difference considering only non-negative values
            int hourDifference = Math.max(totalHoursRequired - totalHoursCompleted, 0);
            
            // Calculate the score based on missing courses and hour difference
            double score = missingCourses.size() * 5 + hourDifference;
            
            // Update the list of programs with a score of 0
            if (score == 0) {
            	programsComplete.add(program);
            }
            
            // Update the best program if the current score is better
            if (score < bestScore) {
                bestProgram = program;
                bestProgramMissingCourses = missingCourses;
                bestProgramHourDifference = hourDifference;
                bestScore = score;
            }
            
            System.out.println(program.getId());
            System.out.println("Score: " + score);
            System.out.println("Missing Courses: " + missingCourses);
            System.out.println("Extra Courses: " + extraCourses);
            System.out.println("Hour Difference: " + hourDifference);
            System.out.println("---------------------");
        }
        
        // If a student meets the requirements for a program it is displayed here, if not it shows the program they are closest to.
        if (bestScore == 0) {
        	System.out.println("Programs that are complete:");
        	for (program program : programsComplete) {
        	    System.out.println("Program ID: " + program.getId());
        	    System.out.println("Degree Type: " + program.getDegreeType());
        	    System.out.println("---------------------");
        	}
        } else {
        	// Output the best program and its details
            System.out.println("The best program available is : " + bestProgram.getId());
            System.out.println("Missing Courses: " + bestProgramMissingCourses);
            System.out.println("Hour Difference: " + bestProgramHourDifference);
            System.out.println("---------------------");
        }
        
        
    }
}
