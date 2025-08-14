package com.apurv.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    private Long id;
    private String name;
    private String school;
    private Boolean isActive;
    private List<SubjectRequestDto> subjects;
}
