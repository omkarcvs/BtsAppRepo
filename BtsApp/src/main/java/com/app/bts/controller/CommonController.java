package com.app.bts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.bts.entity.common.City;
import com.app.bts.entity.common.CommonRepository;
import com.app.bts.entity.common.Country;
import com.app.bts.entity.common.State;

@Controller
public class CommonController {
	
	@Autowired
	CommonRepository cr;
	
	@RequestMapping(value="/loadCountry", method = RequestMethod.GET)
	public String getCountry(ModelMap model)
	{
		model.put("countryList", CommonRepository.getAllCountry());
		model.put("country", new Country());
		return "common/address";
	}
	
	@RequestMapping(value="/loadState", method = RequestMethod.GET)	
	public String getCountry(@ModelAttribute("state") State state,ModelMap model)
	{
		model.put("state", new State());
		model.put("stateList", CommonRepository.getAllStates());
		return "common/state";
	}
	
	/*
	 * @RequestMapping(value="/loadState", method = RequestMethod.GET) public String
	 * getStateList(@ModelAttribute("country") Country country,ModelMap model) {
	 * model.put("stateList", CommonRepository.getAllStates()); return
	 * "common/state"; }
	 */
	
	@RequestMapping(value="/loadCity", method = RequestMethod.GET)	
	public String getCityList(@ModelAttribute("city") City city,ModelMap model)
	{
		model.put("state", new City());
		model.put("cityList", CommonRepository.getAllStates());
		return "common/city";
	}
	
	@RequestMapping(value="/loadList",method = RequestMethod.GET)	
	@ResponseBody
	public List<City> getList(@ModelAttribute("city") City city,ModelMap model)	{
		
		return  CommonRepository.getAllCities();
	}


}
