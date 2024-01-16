package com.anytimedeveloper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anytimedeveloper.entity.Student;
@Service
public interface StudentService {
	
	    List<Student> getAllStudents();
	    Student getStudentById(Long id);
	    Student createStudent(Student student);
	    Student updateStudent(Long id, Student student);
	    void deleteStudent(Long id);

}
