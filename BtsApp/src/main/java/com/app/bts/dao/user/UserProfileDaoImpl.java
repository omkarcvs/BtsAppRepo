package com.app.bts.dao.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.app.bts.entity.user.UserProfile;




/**
 * @author Omkar Singh
 * 2018.08.07 [Updated]
 *
 */
//@Repository("userProfileDao")
public class UserProfileDaoImpl  {
/*
	public UserProfile findById(int id) {
		System.out.println("Enter in findById(int id)) : UserProfileDaoImpl " );
		System.out.println("Exit from findById(int id)) : UserProfileDaoImpl " );
		return getByKey(id);
	}

	public UserProfile findByType(String type) {
		System.out.println("Enter in findByType(String type) : UserProfileDaoImpl " );
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		System.out.println("Exit from findByType(String type) : UserProfileDaoImpl " );
		return (UserProfile) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserProfile> findAll(){
		System.out.println("Enter in findAll() : UserProfileDaoImpl " );
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		System.out.println("Enter in findAll() : UserProfileDaoImpl " );
		return (List<UserProfile>)crit.list();
	}
*/	
}
