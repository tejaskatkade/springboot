package com.exam.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.exam.app.entity.User;
import com.exam.app.service.UserService;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

	}

	@Override
	public void run(String... args) {
		System.out.println("Okay  ...!");

		User user = new User(4, "Mahendra", "msd", "msd@gmail.com", "67891", "6543217893", "pqr.png", "user",false);
		User u = userService.createUser(user);

		System.out.println(u.getUserName());
	}

}
