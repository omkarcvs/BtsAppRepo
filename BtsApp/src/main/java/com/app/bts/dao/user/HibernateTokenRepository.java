package com.app.bts.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bts.entity.user.PersistentLogin;

@Repository
public interface HibernateTokenRepository extends JpaRepository<PersistentLogin,String>{
	 
      PersistentLogin findBySeries(String sso);
      PersistentLogin findByUsername(String username);	
      
}
