/*
File: student.java
Author: Paul Stephan
Version: 1.0
Date: Sep 29, 2024

Description: 
    Constructs and defines the student class.
    This class represents individual student records with attributes such as ID, first name, last name, phone number, address, and completed courses.

*/

// Define the package for the class
package studentRecords;

// Import necessary Java utilities
import java.util.ArrayList;
import java.util.List;

// Define the student class
public class student {
    // Define private attributes for the student record
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private List<String> coursesComplete;

    // Constructor to initialize a student record object
    public student(String id, String firstName, String lastName, String phoneNumber, String address, List<String> coursesComplete) {
        // Validate input parameters
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid id");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid number");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        // Assign values to attributes
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.coursesComplete = coursesComplete;
    }

    // Getter methods for retrieving attribute values
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getCoursesComplete() {
        return coursesComplete;
    }

    // Setter methods to update attribute values
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid phone Number");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        if (address == null || address.length() != 10) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }

    public void setCoursesComplete(List<String> coursesComplete) {
        this.coursesComplete = new ArrayList<>(coursesComplete);
    }

}
