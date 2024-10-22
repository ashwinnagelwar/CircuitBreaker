package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/getUser")
	//@CircuitBreaker(name = "userService", fallbackMethod = "fallbackUserService")
	public ResponseEntity<User> getUser()
	{
		User user = userService.getUserDetails();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	

//	public ResponseEntity<User> fallbackUserService(Throwable throwable) {
//	    System.out.println("Address service is down: " + throwable.getMessage());
//	    User user = new User();
//	    user.setId(1);
//	    user.setFName("dummy");
//	    user.setLName("dummy");
//	    user.setAge(32);
//	    user.setAddress(null);
//	    return new ResponseEntity<>(user, HttpStatus.OK);
//	}

}
