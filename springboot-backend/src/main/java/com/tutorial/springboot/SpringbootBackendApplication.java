package com.tutorial.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tutorial.springboot.model.User;
import com.tutorial.springboot.repository.UserRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("Jabid","Methun","jabidmethun@gmail.com"));
		this.userRepository.save(new User("John","Doe","jd@gmail.com"));
		this.userRepository.save(new User("James","Monroe","jm@gmail.com"));
	}
	

}
