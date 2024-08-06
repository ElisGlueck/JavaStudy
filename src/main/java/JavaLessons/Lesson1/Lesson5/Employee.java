package JavaLessons.Lesson1.Lesson5;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class Employee {
    private String fullName;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private int salary;
    private LocalDate dataOfBirth;

    public Employee(String fullName, String jobTitle, String email, String phoneNumber, int salary,  LocalDate dateOfBirth) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.dataOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return Period.between(dataOfBirth, LocalDate.now()).getYears();
    }

    public String toString() {
        return String.format("Employee full name: %s\nAge: %d\nJob Title: %s\nE-mail: %s\nPhone Number: %s\nSalary: %d\n", fullName, getAge(), jobTitle, email, phoneNumber, salary);
    }


}
