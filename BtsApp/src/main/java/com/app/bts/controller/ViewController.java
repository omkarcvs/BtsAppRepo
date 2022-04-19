package com.app.bts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("/ajaxHome")
	public String home() {
		return "ajaxHome";
	}

}
