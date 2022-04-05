package com.app.bts.entity.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class State {
	private Integer id;
	private String name;
	
	private List<City> cities = new ArrayList(0);
	
	
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}
	public State(Integer id, String name, List<City> cities) {
		super();
		this.id = id;
		this.name = name;
		this.cities = cities;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
	
}
