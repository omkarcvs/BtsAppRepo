package com.app.bts.dao.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bts.entity.user.UserProfile;
//import com.oks.school.persistence.dao.IGenericDao;
/**
 * @author Omkar Singh
 * 2018.08.07 [Updated]
 *
 */
@Repository("userProfileDao")
public interface UserProfileDao extends JpaRepository<UserProfile,Integer> {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
	
}
