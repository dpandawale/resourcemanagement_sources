package com.resourcemanagement.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resourcemanagement.dao.CompanyEntityDAO;
import com.resourcemanagement.dao.UserEntityDAO;
import com.resourcemanagement.entity.CompanyEntity;
import com.resourcemanagement.entity.GoalEntity;
import com.resourcemanagement.entity.MeasureEntity;
import com.resourcemanagement.entity.PerspectiveEntity;
import com.resourcemanagement.entity.UserEntity;
import com.resourcemanagement.response.ResponseCode;
import com.resourcemanagement.response.ResponseHandler;
import com.resourcemanagement.utils.StatusUtils;
import com.sun.mail.imap.protocol.Status;

import ch.qos.logback.classic.net.SyslogAppender;
/**
 * 
 * @author Mauli-DITPL
 * User management services,all the services called in this class
 *
 */
@Service
public class UserServices {

	
	/*
	 * @Autowired UserEntityDAO userEntityDAO;
	 */

@Autowired
	CompanyEntityDAO companyEntityDAO;
	
	@Autowired
	UserEntityDAO userEntityDAO;

	private static final Logger logger=LoggerFactory.getLogger(UserServices.class);
	
	public String saveCompany(String data, HttpSession session) {

		System.out.println("Inside service");

		// return companyEntityDAO.saveCompany(data, session);
		CompanyEntity companyEntity = new CompanyEntity();
		companyEntity.setCompanyName("Dynamischit pvt ltd");
		companyEntity.setCompanyAddress("");
		companyEntity.setCreatedAt("");
		companyEntity.setUpdatedAt("");
		companyEntity.setStatus(StatusUtils.ACTIVATED);
		return companyEntityDAO.saveCompany(companyEntity);

	}
/*
	public String getCompanyByCompanyId(String data, HttpSession session) {
		// TODO Auto-generated method stub
		System.out.println("Console printing");
		logger.info("Calling getCompanyByCompanyId service");
		
		long companyId=1;
		return companyEntityDAO.getCompanyByCompanyId(companyId);
	}

	public String getCompanyNameAddressByCompanyId(String data, HttpSession session) {
		// TODO Auto-generated method stub
		long companyId=1;
		return companyEntityDAO.getCompanyNameAddressByCompanyId(companyId);

	}

	public String getCompanyNames(String data, HttpSession session) {
		// TODO Auto-generated method stub
		return companyEntityDAO.getCompanyNames();
	}
*/
	public String saveUser(String data, HttpSession session) {
		String password="abc";
		String createdAt="abc";
		String updatedAt="abc";
		Long companyId=(long) 1;
		String firstName="abc";
		Integer status=3;
		Integer userType = 2;
		String emailId="abc";
		String lastName="abc";
		String phone="abc";
		Integer type=9;
		CompanyEntity companyEntity=companyEntityDAO.getCompanyEntityByCompanyId(companyId);
		if(companyEntity==null)
		{
			return ResponseHandler.sendResponse(ResponseCode.RECORD_NOT_FOUND, false);
		}
		//return "";
		return userEntityDAO.saveUser(new UserEntity(password,emailId,firstName,lastName,userType,
				status,  type,  createdAt,  updatedAt, phone,
		 companyEntity));
	}
/*
	public String getUserNames(String data, HttpSession session) {
		// TODO Auto-generated method stub
		long companyId=1;
		return userEntityDAO.getUserNames(companyId);
	}

	public String getUserProfileByUserId(String data, HttpSession session) {
		// TODO Auto-generated method stub
		long userId=1;
		long companyId=1;
		return userEntityDAO.getUserProfileByUserId(userId,companyId);
	}

	public String updateUser(String data, HttpSession session) {
		// TODO Auto-generated method stub
		String firstName="dp";
		String lastName="mane";
		String phone="3444";
		long companyId= 3;
		long userId=1;
		CompanyEntity companyEntity=companyEntityDAO.getCompanyEntityByCompanyId(companyId);
		if(companyEntity==null)
		{
			return ResponseHandler.sendResponse(ResponseCode.RECORD_NOT_FOUND, false);
		}
		return userEntityDAO.updateUser(firstName,lastName,phone,companyEntity, userId);
	}
*/
	public String createPerspective(String data, HttpSession session) {
		// TODO Auto-generated method stub
	
		long companyId=1;
		CompanyEntity companyEntity=companyEntityDAO.getCompanyEntityByCompanyId(companyId);
		return userEntityDAO.savePerspective(new PerspectiveEntity("Customer","dtw","dte",1,5,false,false,1,companyEntity));
	}
	public String createGoal(String data, HttpSession session) {
		// TODO Auto-generated method stub
		long perspectiveId=1;
		long companyId=4;
		CompanyEntity companyEntity=companyEntityDAO.getCompanyEntityByCompanyId(companyId);
		PerspectiveEntity perspectiveEntity=companyEntityDAO.getPerspectiveEntityByPerspectiveId(perspectiveId);
		return userEntityDAO.saveGoal(new GoalEntity("testGoal",1,"dt",2,"",false,false,perspectiveEntity));
	}
	public String getGoalListByPerspectiveId(String data, HttpSession session) {
		// TODO Auto-generated method stub
		long perspectiveId=1;
		return userEntityDAO.getGoalListByPerspectiveId(perspectiveId);
	}
	public String createMeasure(String data, HttpSession session) {
		// TODO Auto-generated method stub
		long goalId=1;
		long userId=1;
		UserEntity userEntity=companyEntityDAO.getUserEntityByUserId(userId);
		GoalEntity goalEntity=companyEntityDAO.getGoalEntityByGoalId(goalId);
		String measureName="testMeasure";
		Integer status=1;
		Integer type=4;
		String createdAt="cdte";
		String updatedAt="udte";
		boolean attachment=false;
		boolean discussion=false;
		return userEntityDAO.saveMeasure(new MeasureEntity(measureName,status,type,createdAt,updatedAt,attachment,discussion,goalEntity,userEntity));
	}
	
	public String getPerspectiveListByCompanyId(String data, HttpSession session) {
		long companyId=1;
		return userEntityDAO.getPerspectiveListByCompanyId(companyId);
	}
	
	
}
