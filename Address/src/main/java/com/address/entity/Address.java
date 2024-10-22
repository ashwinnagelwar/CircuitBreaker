package com.address.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	
	private int id;
	private String houseNo;
	private String nearByLocation;
	private String colonyName;
	private String cityName;
	private String districtName;
	private String state;
	private String pincode;
}
