package com.ahmed.student.service;

import com.ahmed.student.dao.StudentRepository;
import com.ahmed.student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentsBySchoolId(Long schoolId) {
        return studentRepository.findAllStudentsBySchoolId(schoolId);
    }
}
