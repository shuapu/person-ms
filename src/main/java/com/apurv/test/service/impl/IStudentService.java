package com.apurv.test.service.impl;

import com.apurv.test.entity.Student;
import com.apurv.test.mapper.StudentMapper;
import com.apurv.test.model.StudentRequestDto;
import com.apurv.test.model.StudentResponseDto;
import com.apurv.test.repository.StudentRepository;
import com.apurv.test.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class IStudentService implements StudentService {
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Override
    public StudentResponseDto saveStudent(StudentRequestDto studentRequestDto) {
        Student student = studentMapper.convertToEntity(studentRequestDto);
        StudentResponseDto studentResponseDto = studentMapper.convertToDto(studentRepository.save(student));
        log.info("Student Created : {}", studentResponseDto);
        return studentResponseDto;
    }

    @Override
    public StudentResponseDto fetchStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> {
            log.info("No Student with id {}", studentId);
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Student data not available for id " + studentId);
        });
        return studentMapper.convertToDto(student);
    }

    @Override
    public List<StudentResponseDto> fetchAllStudents() {
       List<Student> students = studentRepository.findAllStudents();
       return students.stream().map(studentMapper::convertToDto).toList();
    }


}
