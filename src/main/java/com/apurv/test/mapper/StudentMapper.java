package com.apurv.test.mapper;

import com.apurv.test.entity.Student;
import com.apurv.test.entity.Subject;
import com.apurv.test.model.StudentRequestDto;
import com.apurv.test.model.StudentResponseDto;
import com.apurv.test.model.SubjectRequestDto;
import com.apurv.test.model.SubjectResponseDto;
import com.apurv.test.util.EntityDtoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class StudentMapper implements EntityDtoMapper<Student, StudentRequestDto, StudentResponseDto> {

    @Override
    public Student convertToEntity(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentRequestDto, student);
        List<Subject> subjects = studentRequestDto.getSubjects().stream().map(this::copySubject).peek(obj->obj.setStudent(student)).toList();
        student.setSubjects(subjects);
        return student;
    }

    @Override
    public StudentResponseDto convertToDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        BeanUtils.copyProperties(student,studentResponseDto);
        List<SubjectResponseDto> subjects = student.getSubjects().stream().map(this::copySubject).toList();
        studentResponseDto.setSubjects(subjects);
        return studentResponseDto;
    }

    private Subject copySubject(SubjectRequestDto subjectRequestDto) {
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectRequestDto, subject);
        return subject;
    }
    private SubjectResponseDto copySubject(Subject subject) {
        SubjectResponseDto subjectResponseDto = new SubjectResponseDto();
        subjectResponseDto.setId(subject.getId());
        subjectResponseDto.setName(subject.getName());
        subjectResponseDto.setTeacher(subject.getTeacher());
        subjectResponseDto.setSemester(subject.getSemester());
        return subjectResponseDto;
    }

}
