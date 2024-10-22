package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Address;
import com.user.entity.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class UserService {

	  @Autowired
	    private RestTemplate restTemplate;

	    //@CircuitBreaker(name = "userService", fallbackMethod = "fallbackGetUserDetails")
	    @Retry(name = "userService", fallbackMethod = "fallbackGetUserDetails")
	    public User getUserDetails() {
	        Address address = restTemplate.getForObject("http://localhost:8081/address/getAddress", Address.class);
	        User user = new User();
	        user.setId(1);
	        user.setFName("Ashwin");
	        user.setLName("Nagelwar");
	        user.setAge(32);
	        user.setAddress(address);
	        return user;
	    }

	    // Fallback method for circuit breaker
//	    public User fallbackGetUserDetails(Throwable t) {
//	        System.out.println("Address service is down. Fallback executed.");
//	        User user = new User();
//	        user.setId(1);
//	        user.setFName("dummy");
//	        user.setLName("dummy");
//	        user.setAge(32);
//	        user.setAddress(null);
//	        return user;
//	    }
	    
	    
	    //fallback method for Retry
	    int retryCount=1;
	    public User fallbackGetUserDetails(Throwable t) {
	        System.out.println("Address service is down. Fallback executed."+retryCount);
	        User user = new User();
	        user.setId(1);
	        user.setFName("dummy");
	        user.setLName("dummy");
	        user.setAge(32);
	        user.setAddress(null);
	        return user;
	    }
	
}
