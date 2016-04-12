package com.resourcemanagement.hibernate.query;

public enum HibernateQuery 
{
	SELECT_USER_WITH_COMPANY("from User where status!=status and companyId=:companyId"),
	SELECT_COMPANY("From Company where status!=status")
	;
	
	String code;
	HibernateQuery(String code)
	{
		this.code=code;
	}
	public String getQuery()
	{
		return code;
	}

}