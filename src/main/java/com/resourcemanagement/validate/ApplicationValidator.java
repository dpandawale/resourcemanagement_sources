package com.resourcemanagement.validate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.resourcemanagement.entity.CompanyEntity;

public class ApplicationValidator {
	
	public Map<String,Object> validateCompany(CompanyEntity company)
	{
		boolean result=true;
		ArrayList<String> listErrors=new ArrayList<String>();
		if(company.getCompanyName().length()==0)
		{
			listErrors.add(ValidationMessages.COMPANY_NAME_IS_NOT_AVAILABLE);
			result=false;
		}
		
		if(company.getCompanyAddress().length()==0)
		{
			listErrors.add(ValidationMessages.COMPANY_ADDRESS_IS_NOT_AVAILABLE);
			result=false;
		}
		
		
		 Map<String,Object> validateMap=new HashMap<String,Object>();
		 validateMap.put("result", result);
		 validateMap.put("data", listErrors);
		 
		 return validateMap;
	}

}
