package com.ypc.book_my_ticket.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ypc.book_my_ticket.entity.User;
import com.ypc.book_my_ticket.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
public class AdminRegistration implements CommandLineRunner {

	@Value("${admin.email}")
	private String email;
	@Value("${admin.password}")
	private String password;
	@Value("${admin.role}")
	private String role;
	
	private final UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		if(!userRepository.existsByEmail(email)) {
			User user = new User();
			user.setEmail(email);
			user.setPassword(AES.encrypt(password));
			user.setRole(role);
			user.setMobile(0L);
			user.setName("ADMIN");
			userRepository.save(user);
			log.info("Admin Created Successfully.... ");
		}else {
			log.info("Admin Exist...");
		}
		
	}

}
