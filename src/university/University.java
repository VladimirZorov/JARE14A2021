package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (students.size() < capacity) {
            if (!students.contains(student)){
                students.add(student);
              return String.format("Added student %s %s", student.firstName, student.lastName);
            } else {
               return String.format("Student is already in the university");
            }
        } else {
           return String.format("No seats in the university");
        }
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)){
            students.remove(student);
            return String.format("Removed student %s %s", student.firstName, student.lastName);
        } else {
            return String.format("Student not found");
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s ", student.firstName, student.lastName, student.bestSubject)).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }


}
