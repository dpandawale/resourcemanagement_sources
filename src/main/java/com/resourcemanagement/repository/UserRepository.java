package com.resourcemanagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resourcemanagement.dao.UserEntityDAO;
import com.resourcemanagement.entity.CompanyEntity;
import com.resourcemanagement.entity.GoalEntity;
import com.resourcemanagement.entity.MeasureEntity;
import com.resourcemanagement.entity.PerspectiveEntity;
import com.resourcemanagement.entity.UserEntity;
import com.resourcemanagement.response.ResponseCode;
import com.resourcemanagement.response.ResponseHandler;
import com.resourcemanagement.result.CommonResult;
import com.resourcemanagement.result.UserResult;
import com.resourcemanagement.utils.StatusUtils;

@Repository
@Transactional
public class UserRepository implements UserEntityDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
 
	private Session session;
	private Transaction tx;
	
	public UserRepository()
	{
		
	}

	public UserRepository(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public String saveUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		try {
			session.save(userEntity);
			tx.commit();
			return ResponseHandler.sendResponse(ResponseCode.SUCEESS, true);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
			return ResponseHandler.sendResponseWithException(ResponseCode.FAILED, false, e.getMessage());
		}
		finally{
			session.close();
		}
		
	}

	public String getUserNames(long companyId) {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(UserEntity.class)
				    .setProjection(Projections.projectionList()
				      .add(Projections.property("fullName"), "name")
				      .add(Projections.property("userId"), "id"))
				    .setResultTransformer(Transformers.aliasToBean(CommonResult.class))
			        .add(Restrictions.ne("status", StatusUtils.DELETE))
					.add(Restrictions.eq("companyEntity.companyId", companyId));
			List<Object> result = criteria.list();
			tx.commit();
			if (result != null) {
			    return ResponseHandler.sendResponseWithData(ResponseCode.RECORD_FOUND, true, result);
			}
			else{
			    return ResponseHandler.sendResponse(ResponseCode.RECORD_NOT_FOUND, false);
			}
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
			return ResponseHandler.sendResponseWithException(ResponseCode.FAILED, false, e.getMessage());
		}
		finally{
			session.close();
		}
	}

	@Override
	public String getUserProfileByUserId(long userId, long companyId) {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(UserEntity.class)
				    .setProjection(Projections.projectionList()
				    .add(Projections.property("firstName"), "first_name")
				    .add(Projections.property("lastName"), "last_name")
				    .add(Projections.property("userId"), "id")
					.add(Projections.property("phone"), "phone")
					.add(Projections.property("company.companyName"), "company_name"))
				    .setResultTransformer(Transformers.aliasToBean(UserResult.class))
			        .add(Restrictions.ne("status", StatusUtils.DELETE))
					.add(Restrictions.eq("companyEntity.companyId", companyId))
					.add(Restrictions.eq("userId", userId));
			criteria.setFetchMode("companyEntity", FetchMode.JOIN);
    		criteria.createAlias("companyEntity", "company");
			Object result = criteria.uniqueResult();
			tx.commit();
			if (result != null) {
			    return ResponseHandler.sendResponseWithData(ResponseCode.RECORD_FOUND, true, result);
			}
			else{
			    return ResponseHandler.sendResponse(ResponseCode.RECORD_NOT_FOUND, false);
			}
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
			return ResponseHandler.sendResponseWithException(ResponseCode.FAILED, false, e.getMessage());
		}
		finally{
			session.close();
		}
	}

	@Override
	public String updateUser(String firstName, String lastName, String phone, CompanyEntity companyEntity,long userId) {
		// TODO Auto-generated method stub
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(UserEntity.class)
				    .add(Restrictions.eq("userId", userId))
			        .add(Restrictions.ne("status", StatusUtils.DELETE));
			
			UserEntity result = (UserEntity) criteria.uniqueResult();
			if(result!=null)
			{
			/*	result.setCompanyEntity(companyEntity);
				result.setFirstName(firstName);
				result.setLastName(lastName);
				result.setPhone(phone);*/
			}
			tx.commit();
			return ResponseHandler.sendResponse(ResponseCode.SUCEESS, true);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
			return ResponseHandler.sendResponseWithException(ResponseCode.FAILED, false, e.getMessage());
		}
		finally{
			session.close();
		}
	}

	@Override
	public String savePerspective(PerspectiveEntity perspectiveEntity) {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		try {
			session.save(perspectiveEntity);
			tx.commit();
			return ResponseHandler.sendResponse(ResponseCode.SUCEESS, true);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
			return ResponseHandler.sendResponseWithException(ResponseCode.FAILED, false, e.getMessage());
		}
		finally{
			session.close();
		}
	}

	@Override
	public String saveGoal(GoalEntity goalEntity) {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		try {
			session.save(goalEntity);
			tx.commit();
			return ResponseHandler.sendResponse(ResponseCode.SUCEESS, true);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
			return ResponseHandler.sendResponseWithException(ResponseCode.FAILED, false, e.getMessage());
		}
		finally{
			session.close();
		}
	}

	@Override
	public String getGoalListByPerspectiveId(long perspectiveId) {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(GoalEntity.class,"goal")
					.createAlias("goal.perspectiveEntity", "perspective")
					.createAlias("perspective.companyEntity", "company")
			        .add(Restrictions.ne("goal.status", StatusUtils.DELETE))
					.add(Restrictions.eq("company.companyId", perspectiveId));
			List<Object> result = criteria.list();
			tx.commit();
			if (result != null) {
			    return ResponseHandler.sendResponseWithData(ResponseCode.RECORD_FOUND, true, result);
			}
			else{
			    return ResponseHandler.sendResponse(ResponseCode.RECORD_NOT_FOUND, false);
			}
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
			return ResponseHandler.sendResponseWithException(ResponseCode.FAILED, false, e.getMessage());
		}
		finally{
			session.close();
		}
	}

	@Override
	public String saveMeasure(MeasureEntity measureEntity) {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		try {
			session.save(measureEntity);
			tx.commit();
			return ResponseHandler.sendResponse(ResponseCode.SUCEESS, true);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
			return ResponseHandler.sendResponseWithException(ResponseCode.FAILED, false, e.getMessage());
		}
		finally{
			session.close();
		}
	}

	@Override
	public String getPerspectiveListByCompanyId(long companyId) {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(PerspectiveEntity.class,"perspective")
					.createAlias("perspective.companyEntity", "company")
			        .add(Restrictions.ne("perspective.status", StatusUtils.DELETE))
					.add(Restrictions.eq("company.companyId", companyId));
			List<Object> result = criteria.list();
			tx.commit();
			if (result != null) {
			    return ResponseHandler.sendResponseWithData(ResponseCode.RECORD_FOUND, true, result);
			}
			else{
			    return ResponseHandler.sendResponse(ResponseCode.RECORD_NOT_FOUND, false);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
			return ResponseHandler.sendResponseWithException(ResponseCode.FAILED, false, e.getMessage());
		}
		finally{
			session.close();
		}
	}

	@Override
	public String getUserListByCompanyId(long companyId) {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(UserEntity.class,"user")
					.createAlias("user.companyEntity", "company")
			        .add(Restrictions.ne("user.status", StatusUtils.DELETE))
					.add(Restrictions.eq("company.companyId", companyId));
			List<Object> result = criteria.list();
			tx.commit();
			if (result != null) {
			    return ResponseHandler.sendResponseWithData(ResponseCode.RECORD_FOUND, true, result);
			}
			else{
			    return ResponseHandler.sendResponse(ResponseCode.RECORD_NOT_FOUND, false);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
			return ResponseHandler.sendResponseWithException(ResponseCode.FAILED, false, e.getMessage());
		}
		finally{
			session.close();
		}
	}
}
