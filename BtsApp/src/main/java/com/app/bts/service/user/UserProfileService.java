package com.app.bts.service.user;

import java.util.List;

import com.app.bts.entity.user.UserProfile;

/**
 * @author Omkar Singh
 * 2018.08.07 [updated]
 *
 */
public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
