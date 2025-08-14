package com.apurv.test.resources;

import com.apurv.test.model.StudentRequestDto;
import com.apurv.test.model.StudentResponseDto;
import com.apurv.test.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1/student")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto student = studentService.saveStudent(studentRequestDto);
        return ResponseEntity.ok(student);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentResponseDto> fetchStudentById(@PathVariable(name = "id") Long studentId){
        StudentResponseDto student = studentService.fetchStudent(studentId);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<StudentResponseDto>> fetchAllStudents(){
        List<StudentResponseDto> student = studentService.fetchAllStudents();
        return ResponseEntity.ok(student);
    }



}
