package com.app.bts.dao.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bts.entity.user.User;
/**
 * @author Omkar Singh
 * 2018.08.07 [Updated]
 *
 */
@Repository("userDao")
public interface UserDao extends JpaRepository<User, Integer> {

	User findById(int id);
	
	User findBySsoId(String sso);
	
	//void save(User user);
	
	void deleteBySsoId(String sso);
	
	//List<User> findAllUsers();
	
	List<User> findByDeptId(Long departmentId);

}

