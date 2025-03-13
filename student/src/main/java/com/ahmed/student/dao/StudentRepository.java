package com.ahmed.student.dao;

import com.ahmed.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllStudentsBySchoolId(Long schoolId);
}
