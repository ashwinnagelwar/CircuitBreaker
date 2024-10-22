package com.address.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.address.entity.Address;

@RestController
@RequestMapping("/address")
public class AddressController {

	@GetMapping("/getAddress")
	public ResponseEntity<Address> getAddress()
	{
		Address address=new Address(1, "102", "Near Radha Krishna Mandir", "Sardar Patel Ward", "Warora", "Chandrapur", "Maharashtra", "442907");
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
	
}
