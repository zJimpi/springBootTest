package com.sms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

	
	private int addId;
	
	@Size(max=100, message="Max limit 100 charecters")
	@NotNull(message="Locality is required")
	private String locality;
	
	@Size(max=50, message="max limit 50 charecters")
	@Size(min=2, message="min 2 charecter required")
	@NotNull(message="city is required")
	private String city;
	
	@Size(max=30, message="max limit 30 charecters")
	@Size(min=3, message="min 3 charecter required")
	@NotNull(message="state is required")
	private String state;
	
	@Size(min=6, max=6, message="6 charecters required")
	@NotNull(message="pincode is required")
	private int pincode;
}
