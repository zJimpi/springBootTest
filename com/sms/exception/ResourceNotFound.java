package com.sms.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	//eg: dept,student..
	private String resourceName;

	//eg: name,roll.. dept_name
	private String feildName;
	
	//eg: bca bba,99 ,sangita
	private Object feildValue;
	
	
	public ResourceNotFound(String resourceName, String feildName, Object feildValue) {
		super(String.format("%s not found with %s : '%s'",resourceName,feildName,feildValue));
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}

	
}
