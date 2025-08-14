package com.apurv.test.service.impl;

import com.apurv.test.entity.User;
import com.apurv.test.mapper.UserMapper;
import com.apurv.test.model.UserRequestDto;
import com.apurv.test.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(()->{
            log.info("User not found!!");
            return new UsernameNotFoundException("User not found!!");
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
    }

    public String registerUser(UserRequestDto userRequestDto){
        try {
            User user = userMapper.convertToEntity(userRequestDto);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            var savedUser = userRepository.save(user);
            log.info("{} successfully registered!!",savedUser.getUsername());
            return String.format("User %s successfully registered.",savedUser.getUsername());
        } catch (Exception e) {
            log.error(e.toString());
            return String.format("User %s registration failed.",userRequestDto.getUsername());
        }


    }


}
