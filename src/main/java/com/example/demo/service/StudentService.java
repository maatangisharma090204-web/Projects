package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Create
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    // Read all
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Read one
    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    // Update
    public Student updateStudent(int id, Student student) {

        Student oldStudent = repository.findById(id).orElse(null);

        if (oldStudent != null) {
            oldStudent.setName(student.getName());
            oldStudent.setYear(student.getYear());
            oldStudent.setBranch(student.getBranch());
            oldStudent.setSemester(student.getSemester());

            return repository.save(oldStudent);
        }

        return null;
    }

    // Delete
    public String deleteStudent(int id) {

        repository.deleteById(id);

        return "Student deleted successfully";
    }
}