package com.app.bts.dao.user;

//import com.oks.school.persistence.dao.GenericDao;





/**
 * @author Omkar Singh
 * 2018.08.07 [Updated]
 *
 */
//@Repository("userDao")

public class UserDaoImpl  {
/*
	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	public User findById(int id) {
		System.out.println("Enter in findById(int id)) : UserDaoImpl " );
		User user = getByKey(id);
		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
		}
		System.out.println("Exit from findById(int id)) : UserDaoImpl " );
		return user;
	}

	public User findBySSO(String sso) {
		System.out.println("Enter in findBySSO(String sso) : UserDaoImpl  ....: sso:  " +sso  );
		logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user = (User)crit.uniqueResult();
		
		System.out.println("1111111111111111111111111111111111111111111");
		
		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
			System.out.println("22222222222222222222222222222222222222222222");
		}
		System.out.println("1111111111111111111111111111111111111111111");
		System.out.println("Exit findBySSO(String sso) : UserDaoImpl  ....: sso:  " +sso  );
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		System.out.println("Enter in findAllUsers() : UserDaoImpl " );
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<User> users = (List<User>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		//
		//for(User user : users){
		///	Hibernate.initialize(user.getUserProfiles());
		//}
		//System.out.println("Exit from findAllUsers() : UserDaoImpl " );
		return users;
	}

	public void save(User user) {
		System.out.println("Enter in save(User user) : UserDaoImpl " );
		persist(user);
		System.out.println("Exit from save(User user) : UserDaoImpl " );
	}

	public void deleteBySSO(String sso) {
		System.out.println("Enter in deleteBySSO(String sso) : UserDaoImpl " );
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user = (User)crit.uniqueResult();
		delete(user);
		System.out.println("Enter in deleteBySSO(String sso) : UserDaoImpl " );
	}
*/
}
