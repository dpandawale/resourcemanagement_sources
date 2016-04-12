package com.resourcemanagement.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resourcemanagement.dao.CompanyEntityDAO;
import com.resourcemanagement.entity.CompanyEntity;
import com.resourcemanagement.hibernate.query.HibernateQuery;
import com.resourcemanagement.response.ResponseCode;
import com.resourcemanagement.response.ResponseHandler;
import com.resourcemanagement.services.UserServices;
/**
 * 
 * @author Mauli-DITPL
 * This is Controller class which is responsible for all the request which are coming from server side
 * 
 *
 */
@Controller
public class RequestHandler {
	
	@Autowired
	UserServices userServices;
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String checkUser(@RequestBody String data, HttpSession session) {

		/*try {
			return userServices.validateUser(data, session);
		} catch (Exception e) {
			return JsonResponse.responseFailureWithServiceCall();
		}*/
		
		System.out.println("Hello World");
		//return companyEntityDAO.saveCompany(data, session);
		CompanyEntity companyEntity=new CompanyEntity();
		companyEntity.setCompanyName("Dynamischit pvt ltd");
		companyEntity.setCompanyAddress("");
		companyEntity.setCreatedAt("");
		companyEntity.setUpdatedAt("");
		companyEntity.setStatus(1);
		//return userServices.saveCompany(companyEntity);
		return userServices.saveCompany(data, session);
		
		
		//return ""+HibernateQuery.SELECT_COMPANY.getQuery();
		
	}/*
	@RequestMapping(value = "/getCompanyByCompanyId", method = RequestMethod.GET)
	public @ResponseBody String getCompanyByCompanyId(@RequestBody String data, HttpSession session) {
			return userServices.getCompanyByCompanyId(data,session);
	}
	
	@RequestMapping(value = "/getCompanyNameAddressByCompanyId", method = RequestMethod.GET)
	public @ResponseBody String getCompanyNameAddressByCompanyId(@RequestBody String data, HttpSession session) {
			return userServices.getCompanyNameAddressByCompanyId(data,session);
	}
	@RequestMapping(value = "/getCompanyNames", method = RequestMethod.GET)
	public @ResponseBody String getCompanyNames(@RequestBody String data, HttpSession session) {
			return userServices.getCompanyNames(data,session);
	}
	
	@RequestMapping(value = "/getUserNames", method = RequestMethod.GET)
	public @ResponseBody String getUserNames(@RequestBody String data, HttpSession session) {
			return userServices.getUserNames(data,session);
	}
	@RequestMapping(value = "/getUserProfileByUserId", method = RequestMethod.GET)
	public @ResponseBody String getUserProfileByUserId(@RequestBody String data, HttpSession session) {
			return userServices.getUserProfileByUserId(data,session);
	}
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public @ResponseBody String updateUser(@RequestBody String data, HttpSession session) {
			return userServices.updateUser(data,session);
	}
	*/
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.GET)
	public @ResponseBody String saveUser(@RequestBody String data, HttpSession session) {
			return userServices.saveUser(data,session);
	}
	
	@RequestMapping(value = "/createPerspective", method = RequestMethod.GET)
	public @ResponseBody String createPerspective(@RequestBody String data, HttpSession session) {
			return userServices.createPerspective(data,session);
	}
	
	@RequestMapping(value = "/createGoal", method = RequestMethod.GET)
	public @ResponseBody String createGoal(@RequestBody String data, HttpSession session) {
			return userServices.createGoal(data,session);
	}
	
	@RequestMapping(value = "/createMeasure", method = RequestMethod.GET)
	public @ResponseBody String createMeasure(@RequestBody String data, HttpSession session) {
			return userServices.createMeasure(data,session);
	}
	
	@RequestMapping(value = "/getGoalListByPerspectiveId", method = RequestMethod.GET)
	public @ResponseBody String getGoalListByPerspectiveId(@RequestBody String data, HttpSession session) {
			return userServices.getGoalListByPerspectiveId(data,session);
	}
	
	@RequestMapping(value = "/getPerspectiveListByCompanyId", method = RequestMethod.GET)
	public @ResponseBody String getPerspectiveListByCompanyId(@RequestBody String data, HttpSession session) {
			return userServices.getPerspectiveListByCompanyId(data,session);
	}
	
}
