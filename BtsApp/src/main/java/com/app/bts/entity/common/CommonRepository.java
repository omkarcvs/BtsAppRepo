package com.app.bts.entity.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CommonRepository {

	static List<Country> countryList=new ArrayList<Country>();
	static List<State> stateList=new ArrayList<State>();
	static List<City> cityList=new ArrayList<City>();

	public CommonRepository() {
		
		City city1=new City(1, "Gorakhpur");
		City city2=new City(2, "Lucknow");
		City city3=new City(3, "Kanpur");
		City city4=new City(4, "Varansi");
		City city5=new City(5, "Noida");
		
		cityList.add(city1);
		cityList.add(city1);
		cityList.add(city1);
		cityList.add(city1);
		cityList.add(city1);
		
		
	    State s1=new State(1, "UP", cityList);
	    State s2=new State(2, "MP", Arrays.asList(new City(1, "MP_City01"),new City(2,  "MP_City02"),new City(2,  "MP_City03")));
	    State s3=new State(3, "HP",  Arrays.asList(new City(1, "HP_City01"),new City(2,  "HP_City02")));
	    
	    stateList.add(s1);
	    stateList.add(s2);
	    stateList.add(s3);
	    
	    Country c1=new Country(1, "India", stateList);
	    Country c2=new Country(2, "America", Arrays.asList(s1,s2,s3));
	    Country c3=new Country(3, "Japan", Arrays.asList(s1,s2,s3));
	    
	    countryList.add(c1);
	    countryList.add(c2);
	    countryList.add(c3);
	   
	       
	       
	}
	
	public static List<Country> getAllCountry()
	{
		return countryList;
	}
	public static List<State> getAllStates()
	{
		return stateList;
	}
	public static List<City> getAllCities()
	{
		return cityList;
	}
	
	
}
