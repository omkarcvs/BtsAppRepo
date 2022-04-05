package com.app.bts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.bts.entity.DepartmentEntity;
import com.app.bts.entity.common.Product;
import com.app.bts.entity.common.ProductModel;
import com.app.bts.entity.user.User;
import com.app.bts.service.BillFileService;
import com.app.bts.service.BillTrackService;
import com.app.bts.service.DepartmentService;
import com.app.bts.service.user.UserService;


@RestController
@RequestMapping("bts/api/ajaxrest")
public class AjaxRestBillFileController {

	@Autowired
	BillFileService billFileService;
	
	@Autowired
	DepartmentService deptService;	
	
	@Autowired
	BillTrackService billTrackService;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "loadEmployees/{departmentId}", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<User>> getAllEmployees(@PathVariable("departmentId") String departmentId) {
		try {
			
			
			 System.out.println("departmentId :"+departmentId);
			
			//    List<DepartmentEntity> listOfDepartment=deptService.getDeptList();
			  //  model.put("listOfDepartment", listOfDepartment);
			    
			   // List<User> listOfEmployees=userService.findAllUsers();
			    List<User> listOfEmployees=userService.findByDeptId(Long.parseLong(departmentId));
			    ResponseEntity<List<User>> responseEntity = new ResponseEntity<List<User>>(listOfEmployees,HttpStatus.OK);
			  //  model.put("listOfEmployees", listOfEmployees);
			
			    
			    
			
			//ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(productModel.findAll(),HttpStatus.OK);
			
			
			
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	/*
	@RequestMapping(value = "demo1", method = RequestMethod.GET, produces = { MimeTypeUtils.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> demo1() {
		try {
			ResponseEntity<String> responseEntity = new ResponseEntity<String>("Demo 1", HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "demo2/{fullName}", method = RequestMethod.GET, produces = {
			MimeTypeUtils.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> demo2(@PathVariable("fullName") String fullName) {
		try {
			ResponseEntity<String> responseEntity = new ResponseEntity<String>("Hi " + fullName, HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "demo3", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<Product> demo3() {
		try {
			ProductModel productModel = new ProductModel();
			ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(productModel.find(), HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "demo4", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Product>> demo4() {
		try {
			ProductModel productModel = new ProductModel();
			ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(productModel.findAll(),
					HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "demo5", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Product>> demo5() {
		try {
			ProductModel productModel = new ProductModel();
			ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(productModel.findAll(),
					HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
  */
}