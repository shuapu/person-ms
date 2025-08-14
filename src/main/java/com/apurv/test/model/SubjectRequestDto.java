package com.apurv.test.model;

import lombok.Data;

@Data
public class SubjectRequestDto {
    private Long id;
    private String name;
    private String teacher;
    private String semester;
}
