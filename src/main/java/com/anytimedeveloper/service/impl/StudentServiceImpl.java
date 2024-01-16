package com.anytimedeveloper.service.impl;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.anytimedeveloper.entity.Student;
import com.anytimedeveloper.repository.StudentRepository;
import com.anytimedeveloper.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService  {
	
	@Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> optionalExistingStudent = studentRepository.findById(id);
        if (optionalExistingStudent.isPresent()) {
            Student existingStudent = optionalExistingStudent.get();
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setRollNo(updatedStudent.getRollNo());

            return studentRepository.save(existingStudent);
        } else {
            return null; // Handle non-existent student as needed
        }
    }

    @Override
    public void deleteStudent(Long id) {
        try {
        	studentRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
        	throw new RuntimeErrorException(null, "Student with id " + id + "not found");
        }
    }
	

}
