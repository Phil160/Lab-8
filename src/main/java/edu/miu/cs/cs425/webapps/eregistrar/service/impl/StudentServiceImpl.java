package edu.miu.cs.cs425.webapps.eregistrar.service.impl;

import edu.miu.cs.cs425.webapps.eregistrar.model.Student;
import edu.miu.cs.cs425.webapps.eregistrar.repository.StudentRepository;
import edu.miu.cs.cs425.webapps.eregistrar.service.StudentService;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Long studentId) {
         studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> findByKeyword(String keyword) {
        return studentRepository.findByKeyword(keyword);
    }
}
