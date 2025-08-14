package com.apurv.test.mapper;

import com.apurv.test.entity.Subject;
import com.apurv.test.model.SubjectRequestDto;
import com.apurv.test.model.SubjectResponseDto;
import com.apurv.test.util.EntityDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper implements EntityDtoMapper<Subject, SubjectRequestDto, SubjectResponseDto> {
    @Override
    public Subject convertToEntity(SubjectRequestDto subjectRequestDto) {
        return null;
    }

    @Override
    public SubjectResponseDto convertToDto(Subject subject) {
        return null;
    }
}
