package com.app.bts.entity.common;

public class City {
	private Integer id;
	private String name;
	public City(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
