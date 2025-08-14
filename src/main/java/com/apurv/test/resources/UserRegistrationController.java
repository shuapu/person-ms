package com.apurv.test.resources;

import com.apurv.test.model.UserRequestDto;
import com.apurv.test.service.impl.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/v1/registration")
@Slf4j
@AllArgsConstructor
public class UserRegistrationController {
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequestDto userRequestDto){
       String msg = userService.registerUser(userRequestDto);
       return ResponseEntity.ok(msg);
    }

}
