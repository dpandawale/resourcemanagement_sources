package com.resourcemanagement.response;

public enum ResponseCode 
{
	FAILED("Unable to Update"),
	SUCEESS("Update complete"),
	RECORD_FOUND("Record Found"),
	RECORD_NOT_FOUND("Record Not Found")
	;
	
	String code;
	ResponseCode(String code)
	{
		this.code=code;
	}
	public String value()
	{
		return code;
	}

}