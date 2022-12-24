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

        return null;
    }

    public String dismissStudent(Student student) {
        return null;
    }

    public String getStudent(String firstName, String lastName) {
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("o\t\"==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject} ")
        return null;
    }


}
