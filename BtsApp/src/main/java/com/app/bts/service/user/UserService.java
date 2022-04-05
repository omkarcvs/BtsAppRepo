package com.app.bts.service.user;

import java.util.List;

import com.app.bts.entity.user.User;



/**
 * @author Omkar Singh
 * 2018.08.07 [updated]
 *
 */


public interface UserService {
	
	User findById(int id);
	
	User findBySSO(String sso);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserBySSO(String sso);

	List<User> findAllUsers(); 
	
	boolean isUserSSOUnique(Integer id, String sso);
	
	List<User> findByDeptId(Long departmentId);

}