package com.resourcemanagement.dao;

import com.resourcemanagement.entity.CompanyEntity;
import com.resourcemanagement.entity.GoalEntity;
import com.resourcemanagement.entity.MeasureEntity;
import com.resourcemanagement.entity.PerspectiveEntity;
import com.resourcemanagement.entity.UserEntity;

public interface UserEntityDAO {

	String saveUser(UserEntity userEntity);
		
	String savePerspective(PerspectiveEntity perspectiveEntity);

	String getUserNames(long companyId);

	String getUserProfileByUserId(long userId,long companyId);

	String updateUser(String firstName, String lastName, String phone, CompanyEntity companyEntity,long userId);

	String saveGoal(GoalEntity goalEntity);

	String getGoalListByPerspectiveId(long perspectiveId);

	String saveMeasure(MeasureEntity measureEntity);

	String getPerspectiveListByCompanyId(long companyId);

	String getUserListByCompanyId(long companyId);

	String getUserByUserId(Long userId);

}
