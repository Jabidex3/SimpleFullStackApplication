package com.tutorial.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springboot.model.User;
import com.tutorial.springboot.repository.UserRepository;

@RestController
@RequestMapping("api/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("users")
	public List<User> getUsers(){
		return this.userRepository.findAll();
	}
	
	  @PostMapping("/users")
	  User newUser(@RequestBody User newUser) {
		ArrayList<User>allUsers = (ArrayList<User>) userRepository.findAll();
//		for(int i=0;i<allUsers.size();i++) {
//			System.out.println(allUsers.get(i));
//		}
		boolean usedEmail=false;
		for(int i=0;i<allUsers.size();i++) {
//			System.out.println(newUser.getEmail());
//			System.out.println(allUsers.get(i).getEmail());
//			System.out.println(newUser.getEmail().equals(allUsers.get(i).getEmail()));
			if(newUser.getEmail().equals(allUsers.get(i).getEmail())==true){
				usedEmail =true;
				break;
			}

		}
		if(usedEmail) {
			//return null;
			 throw new RuntimeException("Email Entered is already Associted With an account");

		}
		else {
			return userRepository.save(newUser);
		}
		
		
	    //return userRepository.save(newUser);
	  }

	
}
