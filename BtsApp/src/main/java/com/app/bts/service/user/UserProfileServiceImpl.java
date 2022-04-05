package com.app.bts.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.bts.dao.user.UserProfileDao;
import com.app.bts.entity.user.UserProfile;



/**
 * @author Omkar Singh
 * 2018.08.07 [updated]
 *
 */
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	UserProfileDao dao;
	
	public UserProfile findById(int id) {
		System.out.println("Enter in findById(int id)) : UserProfileServiceImpl " );
		UserProfile p=dao.findById(id);
		System.out.println("exit from findById(int id)) : UserProfileServiceImpl " );
		//return dao.findById(id);
		return p;
	}

	public UserProfile findByType(String type){
		System.out.println("Enter in findByType(String type) : UserProfileServiceImpl " );
		UserProfile p=dao.findByType(type);
		//return dao.findByType(type);
		System.out.println("Exit from findByType(String type) : UserProfileServiceImpl " );

		return p;
	}

	public List<UserProfile> findAll() {
		System.out.println("Enter in findAll() : UserProfileServiceImpl " );
		List<UserProfile> plist=dao.findAll();
		//return dao.findAll();
		System.out.println("Exit from findAll() : UserProfileServiceImpl " );
		return plist;
	}
}
