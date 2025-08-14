package com.apurv.test;

import com.apurv.test.entity.User;
import com.apurv.test.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	public CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder){
		return args -> {
			try {
				userRepository.findByUsername("admin");

			} catch(Exception e) {
				User user = new User();
				user.setUsername("admin");
				user.setPassword(passwordEncoder.encode("admin"));
				user.setRole("admin");
				userRepository.save(user);
			}
		};
	}
}
