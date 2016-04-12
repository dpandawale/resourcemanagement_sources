package com.resourcemanagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resourcemanagement.dao.CompanyEntityDAO;
import com.resourcemanagement.entity.CompanyEntity;
import com.resourcemanagement.entity.GoalEntity;
import com.resourcemanagement.entity.PerspectiveEntity;
import com.resourcemanagement.entity.UserEntity;
import com.resourcemanagement.response.ResponseCode;
import com.resourcemanagement.response.ResponseHandler;
import com.resourcemanagement.result.CommonResult;
import com.resourcemanagement.result.CompanyResult;
import com.resourcemanagement.utils.StatusUtils;
/**
 * Repository class which is having implementation of companyEntity DAO
 * @author Mauli-DITPL
 * 
 */
@Repository
@Transactional
public class CompanyRepository implements CompanyEntityDAO {

	@Autowired
	private SessionFactory sessionFactory;
 
	private Session session;
	private Transaction tx;
	
	public CompanyRepository()
	{
		
	}
	public CompanyRepository(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	
	public String saveCompany(CompanyEntity companyEntity) {
		// TODO Auto-generated method stub
		this.session=sessionFactory.openSession();
		this.tx=session.beginTransaction();
		try {
			session.save(companyEntity);
			tx.commit();
			return ResponseHandler.sendResponse(ResponseCode.SUCEESS, true);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseHandler.sendResponseWithException(ResponseCode.FAILED, false, e.getMessage());
		}
	}
	public String getCompanyByCompanyId(long companyId) {
		// TODO Auto-generated method stub
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(CompanyEntity.class)
			        .add(Restrictions.eq("companyId", companyId))
			        .add(Restrictions.ne("status", StatusUtils.DELETE));
			
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
	public String getCompanyNameAddressByCompanyId(long companyId) {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(CompanyEntity.class)
				    .setProjection(Projections.projectionList()
				      .add(Projections.property("companyName"), "name")
				      .add(Projections.property("companyAddress"), "address"))
				    .setResultTransformer(Transformers.aliasToBean(CompanyResult.class))
				    .add(Restrictions.eq("companyId", companyId))
			        .add(Restrictions.ne("status", StatusUtils.DELETE));
			
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
	
	public String getCompanyNames() {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(CompanyEntity.class)
				    .setProjection(Projections.projectionList()
				      .add(Projections.property("companyName"), "name")
				      .add(Projections.property("companyId"), "id"))
				    .setResultTransformer(Transformers.aliasToBean(CommonResult.class))
			        .add(Restrictions.ne("status", StatusUtils.DELETE));
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
	public CompanyEntity getCompanyEntityByCompanyId(Long companyId) {
		// TODO Auto-generated method stub	
		try {
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
		Criteria criteria = session.createCriteria(CompanyEntity.class)
			    .add(Restrictions.eq("companyId", companyId))
		        .add(Restrictions.ne("status", StatusUtils.DELETE));
		
		CompanyEntity result = (CompanyEntity) criteria.uniqueResult();
		tx.commit();
		
		return result;
		
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		tx.rollback();
		e.printStackTrace();
	}
	finally{
		session.close();
	}
		return null;

	}
	public PerspectiveEntity getPerspectiveEntityByPerspectiveId(long perspectiveId) {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(PerspectiveEntity.class)
				    .add(Restrictions.eq("perspectiveId", perspectiveId))
			        .add(Restrictions.ne("status", StatusUtils.DELETE));
			
			PerspectiveEntity result = (PerspectiveEntity) criteria.uniqueResult();
			tx.commit();
			
			return result;
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
			return null;
	}
	public UserEntity getUserEntityByUserId(Long userId) {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(UserEntity.class)
				    .add(Restrictions.eq("userId", userId))
			        .add(Restrictions.ne("status", StatusUtils.DELETE));
			
			UserEntity result = (UserEntity) criteria.uniqueResult();
			tx.commit();
			
			return result;
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
			return null;
	}
	public GoalEntity getGoalEntityByGoalId(long goalId) {
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Criteria criteria = session.createCriteria(GoalEntity.class)
				    .add(Restrictions.eq("goalId", goalId))
			        .add(Restrictions.ne("status", StatusUtils.DELETE));
			
			GoalEntity result = (GoalEntity) criteria.uniqueResult();
			tx.commit();
			
			return result;
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
			return null;
	}
	
	
}
