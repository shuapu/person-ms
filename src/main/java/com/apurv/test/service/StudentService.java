package com.apurv.test.service;

import com.apurv.test.model.StudentRequestDto;
import com.apurv.test.model.StudentResponseDto;

import java.util.List;

public interface StudentService {
    StudentResponseDto saveStudent(StudentRequestDto studentRequestDto);

    StudentResponseDto fetchStudent(Long studentId);

    List<StudentResponseDto> fetchAllStudents();
}
