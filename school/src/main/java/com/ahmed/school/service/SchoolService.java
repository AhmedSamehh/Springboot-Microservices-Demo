package com.ahmed.school.service;

import com.ahmed.school.client.StudentClient;
import com.ahmed.school.dao.SchoolRepository;
import com.ahmed.school.dto.FullSchoolResponse;
import com.ahmed.school.entity.School;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
        var school = schoolRepository.findById(schoolId)
                                .orElse(School.builder()
                                        .name("NOT_FOUND")
                                        .email("NOT_FOUND")
                                        .build()
                                );
        var students = studentClient.findAllStudentsBySchoolId(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
