package edu.miu.cs.cs425.webapps.eregistrar.service;

import edu.miu.cs.cs425.webapps.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    public abstract List<Student> getStudents();
    public abstract Student saveStudent(Student student);
}
