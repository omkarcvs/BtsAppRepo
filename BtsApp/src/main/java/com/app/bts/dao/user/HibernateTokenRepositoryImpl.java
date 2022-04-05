package com.app.bts.dao.user;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.app.bts.entity.user.PersistentLogin;


/**
 * @author Omkar Singh
 * 2018.08.07 [Updated]
 *
 */
//@Repository("tokenRepositoryDao")
//@Transactional
public class HibernateTokenRepositoryImpl	implements PersistentTokenRepository {

	@Autowired
	HibernateTokenRepository tockenRepo;

	static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		logger.info("Creating Token for user : {}", token.getUsername());
		PersistentLogin persistentLogin = new PersistentLogin();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setSeries(token.getSeries());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLast_used(token.getDate());
		tockenRepo.save(persistentLogin);
		//persist(persistentLogin);

	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		logger.info("Fetch Token if any for seriesId : {}", seriesId);
		try {
		/*	Criteria crit = createEntityCriteria();
			crit.add(Restrictions.eq("series", seriesId));
			PersistentLogin persistentLogin = (PersistentLogin) crit.uniqueResult();
		*/ 
			PersistentLogin persistentLogin=tockenRepo.findBySeries(seriesId);
			
			return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
					persistentLogin.getToken(), persistentLogin.getLast_used());
		} catch (Exception e) {
			logger.info("Token not found...");
			return null;
		}
	}

	@Override
	public void removeUserTokens(String username) {
		logger.info("Removing Token if any for user : {}", username);
		/*Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		PersistentLogin persistentLogin = (PersistentLogin) crit.uniqueResult();		*/
		PersistentLogin persistentLogin=tockenRepo.findByUsername(username);
		if (persistentLogin != null) {
			logger.info("rememberMe was selected");
			tockenRepo.delete(persistentLogin);
		}
	}

	@Override
	public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
		logger.info("Updating Token for seriesId : {}", seriesId);
		/*PersistentLogin persistentLogin = getByKey(seriesId);
		persistentLogin.setToken(tokenValue);
		persistentLogin.setLast_used(lastUsed);
		update(persistentLogin);
		*/
		PersistentLogin persistentLogin = tockenRepo.findBySeries(seriesId);
		persistentLogin.setToken(tokenValue);
		persistentLogin.setLast_used(lastUsed);
		tockenRepo.save(persistentLogin);
	}

}
