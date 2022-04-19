package com.app.bts.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
/**
 * @author Omkar Singh
 * 2022.02.28 [updated]
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	PersistentTokenRepository tokenRepository;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	//@Override
	protected void configure_test(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().anyRequest().authenticated();
		http.csrf().disable();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		
		http.authorizeRequests().antMatchers("/", "/list")		
				.access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")		
			  
				
		       
		       
				/*	
				.antMatchers("/add-**")
			    .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
			    
			    .antMatchers("/edit-**")
			    .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
			    
			    .antMatchers("/find-**")
			    .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
			    
			    .antMatchers("/findAll-**")
			    .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
			    
			    .antMatchers("/delete-**")
			    .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
			    
			    .antMatchers("/help-**")
			    .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
				*/
				/*Security for BTS bill tracking system */
				.antMatchers("/home","createDakBill", "/createBill", "/dispatchBill", "/receiveBill", "/closeBill", "/trackBill","/loadDakData","/loadForDispatcherData","/loadForReceiverData","/loadForClosingData", "/bts/api/ajaxrest/**","/pay","/bts/api/ajaxrest/create_order","/bts/api/ajaxrest/load_order")		
				.access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")	
				
				.antMatchers("/error")		
				.access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")	
				
				.antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')").antMatchers("/edit-user-*")
				.access("hasRole('ADMIN') or hasRole('DBA')").and().formLogin().loginPage("/login")
				.loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
				.rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
				.tokenValiditySeconds(86400).and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");
		
		        
		
	/*	
	    .antMatchers("/add/**")
	    .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")	
	    
	    .antMatchers("/update/**")	 
		.access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
		
		.antMatchers("/remove/**")
		.access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")*/
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
				"remember-me", userDetailsService, tokenRepository);
		return tokenBasedservice;
	}

	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}
	
	
	/* tiles configuration */
	@Bean
	public UrlBasedViewResolver tilesViewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();

		tilesViewResolver.setViewClass(TilesView.class);

		return tilesViewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();

		String[] defs = { "/WEB-INF/tiles/**/tiles.xml" };

		tilesConfigurer.setDefinitions(defs);

		return tilesConfigurer;
	}


}
