package com.resourcemanagement.dao;

import com.resourcemanagement.entity.CompanyEntity;
import com.resourcemanagement.entity.GoalEntity;
import com.resourcemanagement.entity.PerspectiveEntity;
import com.resourcemanagement.entity.UserEntity;


public interface CompanyEntityDAO {

	String saveCompany(CompanyEntity companyEntity);

	String getCompanyByCompanyId(long companyId);

	String getCompanyNameAddressByCompanyId(long companyId);

	String getCompanyNames();

	CompanyEntity getCompanyEntityByCompanyId(Long companyId);

	PerspectiveEntity getPerspectiveEntityByPerspectiveId(long perspectiveId);
	
	UserEntity getUserEntityByUserId(Long userId);

	GoalEntity getGoalEntityByGoalId(long goalId);


}
