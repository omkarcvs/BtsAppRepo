package com.app.bts.entity.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//https://learningprogramming.net/java/spring-mvc/cascading-dropdown-list-with-ajax-in-spring-mvc-framework-and-spring-data-jpa/
public class Country {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private List<State> states = new ArrayList<State>(0);

	public Country(Integer id, String name, List<State> states) {
		super();
		this.id = id;
		this.name = name;
		this.states = states;
	}

	public Country() {
	}

	public Country(String name) {
		this.name = name;
	}

	public Country(String name, List<State> states) {
		this.name = name;
		this.states = states;
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<State> getStates() {
		return this.states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
}
