package com.app.bts.service.user;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.bts.dao.user.UserDao;
import com.app.bts.entity.user.User;



/**
 * @author Omkar Singh
 * 2018.08.07 [updated]
 * Restructure in spring boot
 * 2022.02.27 [created]
 *
 */


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findById(int id) {
		System.out.println("Enter in findById(int id)) : UserServiceImpl " );		
		User u=dao.findById(id);
		System.out.println("Exit from findById(int id)) : UserServiceImpl " );
		//return dao.findById(id);
		return u;
	}

	public User findBySSO(String sso) {
		System.out.println("Enter in findBySSO(String sso) : UserServiceImpl ....: sso:  " +sso );	
		User user = dao.findBySsoId(sso);
		System.out.println("Exit from findBySSO(String sso) : UserServiceImpl  ....: sso:  " +sso  );
		return user;
		
	}

	public void saveUser(User user) {
		System.out.println("Enter in saveUser(User user)  : UserServiceImpl " );	
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
		System.out.println("Exit from saveUser(User user)  : UserServiceImpl ttt" );
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		System.out.println("Enter in updateUser(User user)  : UserServiceImpl " );	
		User entity = dao.findById(user.getId()).get();
		if(entity!=null){
			entity.setSsoId(user.getSsoId());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
		System.out.println("Exit from updateUser(User user)  : UserServiceImpl " );
	}

	
	public void deleteUserBySSO(String sso) {
		System.out.println("Enter in deleteUserBySSO(String sso)  : UserServiceImpl " );
		dao.deleteBySsoId(sso);
		System.out.println("Exit from deleteUserBySSO(String sso)  : UserServiceImpl " );
	}

	public List<User> findAllUsers() {
		System.out.println("Enter in findAllUsers()  : UserServiceImpl " );
		List<User> ul=dao.findAll();
		System.out.println("Enxit fromfindAllUsers()  : UserServiceImpl " );
		//return dao.findAllUsers();
		return ul;
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		System.out.println("Enter in isUserSSOUnique(Integer id, String sso)  : UserServiceImpl " );
		User user = findBySSO(sso);
		System.out.println("Exit from isUserSSOUnique(Integer id, String sso)  : UserServiceImpl " );

		return ( user == null || ((id != null) && (user.getId() == id)));
	}

	@Override
	public List<User> findByDeptId(Long departmentId) {
		// TODO Auto-generated method stub
		return dao.findByDeptId(departmentId);
	}
	
	
	
	
}
