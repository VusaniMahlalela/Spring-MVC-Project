package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import com.tpe.repository.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;



    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    @Override
    public Student findStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student not found with id: "+id));
        return student;
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }
}
