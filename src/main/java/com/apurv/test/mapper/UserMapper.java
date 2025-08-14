package com.apurv.test.mapper;

import com.apurv.test.entity.User;
import com.apurv.test.model.UserRequestDto;
import com.apurv.test.model.UserResponseDto;
import com.apurv.test.util.EntityDtoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements EntityDtoMapper<User, UserRequestDto, UserResponseDto> {

    @Override
    public User convertToEntity(UserRequestDto userRequestDto) {
        User user = new User();
        BeanUtils.copyProperties(userRequestDto,user);
        return user;
    }

    @Override
    public UserResponseDto convertToDto(User user) {
        return null;
    }
}
